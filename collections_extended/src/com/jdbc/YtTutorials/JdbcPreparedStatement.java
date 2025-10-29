package com.jdbc.YtTutorials;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class JdbcPreparedStatement {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "devuser";
    private static final String password = System.getenv("MYSQL_PASS");

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(url,username,password)) {

            String query = "insert into students(name, age, marks) values(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.println("Enter you name: ");
                String name = scanner.next();
                System.out.println("Enter you age: ");
                int age = scanner.nextInt();
                System.out.println("Enter you marks: ");
                int marks = scanner.nextInt();
                System.out.println("Enter more data(Y/N): ");
                String choice = scanner.next();
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setInt(3,marks);
                preparedStatement.addBatch();

                if(choice.toUpperCase().equals("N")){
                    break;
                }

            }
            int[] rowsAffected = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(rowsAffected));

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
