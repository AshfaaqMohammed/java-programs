package com.jdbc.JDBCchallenges;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreFront {

    private static String USE_SCHEMA = "USE storefront";

    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("devuser");
        dataSource.setPassword(System.getenv("MYSQL_PASS"));

        try(Connection connection = dataSource.getConnection(dataSource.getUser(),dataSource.getPassword())){

            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getSQLStateType());

            if (!checkSchema(connection)){
                System.out.println("storefront schema does not exist");
                setUpSchema(connection);
            }
//            int newOrder = addOrder(connection, new String[]{"shoes","shirt","socks"});
//            System.out.println("New Order - " + newOrder);
            deleteOrder(connection,1);
        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }
    }

    private static boolean checkSchema(Connection conn){
        try(Statement statement = conn.createStatement()){
            statement.execute(USE_SCHEMA);
        }catch (SQLException sql){
            sql.printStackTrace();
            System.err.println(sql.getSQLState());
            System.err.println(sql.getErrorCode());
            System.err.println(sql.getMessage());
            return false;
        }
        return true;
    }

    private static void setUpSchema(Connection connection) throws SQLException{
        String createSchema = "CREATE SCHEMA storefront";

        String createOrder = """
                CREATE TABLE storefront.order(
                order_id int NOT NULL AUTO_INCREMENT,
                order_date DATETIME NOT NULL,
                PRIMARY KEY (order_id)
                )""";
        String createOrderDetails = """
                
                CREATE TABLE storefront.order_details(
                order_detail_id int NOT NULL AUTO_INCREMENT,
                item_description text,
                order_id int DEFAULT NULL,
                PRIMARY KEY (order_detail_id),
                KEY FK_ORDERID (order_id),
                CONSTRAINT FK_ORDERID FOREIGN KEY (order_id)
                REFERENCES storefront.order (order_id) ON DELETE CASCADE
                )
                """;

        try (Statement statement = connection.createStatement()){
            System.out.println("Creating storefront database");
            statement.execute(createSchema);
            if (checkSchema(connection)){
                statement.execute(createOrder);
                System.out.println("successfully created order");
                statement.execute(createOrderDetails);
                System.out.println("successfully created order details");
            }
        }
    }

    private static int addOrder(Connection conn, String[] items) throws SQLException{
        int orderId = -1;

        String insertOrder = "INSERT INTO storefront.order (order_date) VALUES ('%s')";
        String insertDetail = "INSERT INTO storefront.order_details (order_id, item_description) values(%d, %s)";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String orderDataTime = LocalDateTime.now().format(dtf);
        System.out.println(orderDataTime);
        String formattedString = insertOrder.formatted(orderDataTime);
        System.out.println(formattedString);

        try (Statement statement = conn.createStatement()){
            conn.setAutoCommit(false);
            int inserts = statement.executeUpdate(formattedString,Statement.RETURN_GENERATED_KEYS);

            if (inserts == 1){
                var rs = statement.getGeneratedKeys();
                if(rs.next()){
                    orderId = rs.getInt(1);
                }
            }

            int count=0;
            for (var item: items){
                formattedString = insertDetail.formatted(orderId,statement.enquoteLiteral(item));
                inserts = statement.executeUpdate(formattedString);
                count += inserts;
            }

            if (count != items.length){
                orderId = -1;
                System.out.println("no of records inserted doesn't equal items recorded");
                conn.rollback();
            }else {
                conn.commit();
            }
            conn.setAutoCommit(true);
        }catch (SQLException e){
            conn.rollback();
            throw new RuntimeException(e);
        }

        return orderId;
    }

    private static void deleteOrder(Connection conn, int orderId) throws SQLException{
        String deleteOrder = "DELETE FROM %s WHERE order_id=%d";
        String parentQuery = deleteOrder.formatted("storefront.order",orderId);
        String childQuery = deleteOrder.formatted("storefront.order_details",orderId);


        try(Statement statement= conn.createStatement()){
            int deletedRecords = statement.executeUpdate(childQuery);
            System.out.printf("%d child records deleted%n",deletedRecords);
            deletedRecords = statement.executeUpdate(parentQuery);
            System.out.printf("%d records deleted %n",deletedRecords);
            if(deletedRecords == 1){
                System.out.printf("order %d was successfully deleted%n",orderId);
                conn.commit();
            }else {
                conn.rollback();
            }

        }catch (SQLException e){
            conn.rollback();
            throw new RuntimeException(e);
        }finally {
            conn.setAutoCommit(true);
        }
    }
}
