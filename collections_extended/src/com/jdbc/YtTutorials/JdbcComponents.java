package com.jdbc.YtTutorials;

/*
    JDBC components -
        1. DriverManager Class
        2. Connection interface
        3. Statement and PreparedStatement interfaces
        4. ResultSet interface


 */

import java.sql.*;

public class JdbcComponents {

    private static final String url = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "devuser";
    private static final String password = System.getenv("MYSQL_PASS");

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(url,username,password)) {

            Statement statement = connection.createStatement();
            String query = "select * from accounts";
//            String query = "insert into students(name,age,marks) values ('%s', %d, %f)".formatted("ash",22,98.9);
//            String query = "update students set marks = %f where id = %d".formatted(89.5,1);
            ResultSet resultSet = statement.executeQuery(query);

//            if (rowsEff <= 0){
//                System.out.println("Something went wrong.");
//            }else{
//                System.out.println("Data inserted successfully.");
//            }

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int accountNumber = resultSet.getInt("account_number");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                System.out.printf("%d %s %d %.2f%n",id,name,accountNumber,balance);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
