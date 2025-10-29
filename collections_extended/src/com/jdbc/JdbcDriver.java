package com.jdbc;

/*
    - why jdbc driver is user for -
        1. Connect to the database
        2. execute sql statements (can be DML,DDL, any CRUD ops)
        3. Execute stored procedures.
        4. Retrieve and process results.


    - java.sql Vs javax.sql
        1. jdbc consists of two packages:
            i) java.sql - core JDBC
            ii) javax.sql - which provides api for server side data source access.

        Purpose                     java.sql            javax.sql
       1. Makes a connection      DriverManager       DataSource
        with driver
       2. Query results           ResultSet           RowSet

    - PreparedStatement -
        1. it is used to execute the same statement multiple times with parameter value placeholders.
        2. it is helpful in preventing sql injection attacks
        syntax -
            SELECT * FROM music.artists WHERE artist_name = ?
 */

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class JdbcDriver {


    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music";

    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog(
                null,"Enter DB username"
        );
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null,pf,"Enter DB Password",JOptionPane.OK_CANCEL_OPTION);
        final char[] password = (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;


        // ** 1st method - using connection driver

//        try(Connection connection = DriverManager.getConnection(
//                CONN_STRING,userName,String.valueOf(password)
//        )){
//            System.out.println("Successfully connection is made to music database");
//            Arrays.fill(password,' ');
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }

        // ** 2nd method - using dataSource

        var dataSource = new MysqlDataSource();
        dataSource.setURL(CONN_STRING);

        try(Connection connection = dataSource.getConnection(userName,String.valueOf(password))){
            System.out.println("Successfully connection is made to music database");
            Arrays.fill(password,' ');
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
