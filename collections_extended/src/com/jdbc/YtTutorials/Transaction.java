package com.jdbc.YtTutorials;

import org.hibernate.annotations.processing.SQL;

import java.sql.*;
import java.util.Scanner;

public class Transaction {
    private static final String url = "jdbc:mysql://localhost:3306/lenden";
    private static final String username = "devuser";
    private static final String password = System.getenv("MYSQL_PASS");

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            connection.setAutoCommit(false);
            String debit_query = "update accounts set balance= balance - ? where account_number=?";
            String credit_query = "update accounts set balance=balance + ? where account_number=?";

            PreparedStatement debit_statement = connection.prepareStatement(debit_query);
            PreparedStatement credit_statement = connection.prepareStatement(credit_query);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter account number: ");
            int account_num = scanner.nextInt();

            System.out.println("Enter amount: ");
            double amount = scanner.nextDouble();



            debit_statement.setDouble(1,amount);
            debit_statement.setInt(2,account_num);

            credit_statement.setDouble(1,amount);
            credit_statement.setInt(2,102);

            debit_statement.executeUpdate();
            credit_statement.executeUpdate();

            if(isSufficient(connection,account_num,amount)){
                connection.commit();
                System.out.println("Transaction successful!!");
            }else{
                connection.rollback();
                System.out.println("Insufficient balance.");
                System.out.println("Transaction Failed!!!");
            }

        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

    static boolean isSufficient(Connection connection, int account_number, double amount){
        try{
            String query = "select balance from accounts where account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,account_number);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                int before_amount = result.getInt("balance");
                System.out.println(before_amount+" " +amount);
                if (before_amount > amount){
                    return true;
                }
            }
            return false;

        }catch (SQLException sql){
            sql.printStackTrace();
            return false;
        }
    }

}
