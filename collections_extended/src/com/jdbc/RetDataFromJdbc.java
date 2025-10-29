package com.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/*

    SQL Injection -
        * it occurs when an attacker attempts to manipulate the data, sent to an applications database query.


 */

public class RetDataFromJdbc {
    public static void main(String[] args) {

        Properties properties = new Properties();
        try{
            properties.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        }catch (IOException io){
            throw new RuntimeException(io);
        }

        String query = "SELECT * FROM music.artists LIMIT 5";

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(properties.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
        dataSource.setDatabaseName(properties.getProperty("databaseName"));

        try(var connection = dataSource.getConnection(properties.getProperty("user"),System.getenv("MYSQL_PASS"));
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(query);

            // how to get metadata of table -
            var meta = resultSet.getMetaData();
            for (int i=1;i<= meta.getColumnCount();i++){
                System.out.println(i + " " + meta.getColumnName(i) + " " + meta.getColumnTypeName(i));
            }

            System.out.println("=".repeat(50));

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString("artist_name"));
            }
        }catch (SQLException sql){
            throw new RuntimeException(sql);
        }


    }
}
