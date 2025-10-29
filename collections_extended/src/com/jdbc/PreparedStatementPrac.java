package com.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class PreparedStatementPrac {
    public static void main(String[] args) {
        var dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");
        try {
            dataSource.setContinueBatchOnError(false);
        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }
        try(Connection connection = dataSource.getConnection("devuser",System.getenv("MYSQL_PASS"))){

            // Single row insert in preparedStatement.
//            String sql = "SELECT * FROM music.albumview where artist_name = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1,"Elf");
//            ResultSet resultSet = ps.executeQuery();
//            printRecords(resultSet);


            // code for batch adding of rows in preparedStatement.
            String sql = "INSERT INTO music.albums (artist_id, album_name) VALUES (?,?)";
            PreparedStatement psInsert = connection.prepareStatement(sql);
            psInsert.setInt(1,161);
            psInsert.setString(2,"Gods Plan");
            psInsert.addBatch(); //adds first insert to batch
            int[] results = psInsert.executeBatch(); //executes the above insert statements, if there are two inserting happence at once.
            System.out.println(Arrays.toString(results));
            System.out.println("Successfully added record.");

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }
    }

    private static boolean printRecords(ResultSet resultSet) throws SQLException{
        boolean foundData =false;
        var meta = resultSet.getMetaData();

        System.out.println("-".repeat(20));

        for(int i=1; i<=meta.getColumnCount();i++){
            System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
        }
        System.out.println();

        while (resultSet.next()){
            for (int i=1;i<=meta.getColumnCount();i++){
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
            foundData=true;
        }
        return foundData;

    }


}
