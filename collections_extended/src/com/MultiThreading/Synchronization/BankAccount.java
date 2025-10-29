package com.MultiThreading.Synchronization;

public class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        try{
            System.out.println("Deposit - Talking to the teller at the bank... ");
            Thread.sleep(7000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        synchronized(new Object()){
            double originalBalance = balance;
            balance+=amount;
            System.out.printf("Starting balance: %.0f, Deposit(%.0f): new balance = %.0f%n", originalBalance, amount, balance);
        }

    }

    synchronized public void withdraw(double amount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        double originalBalance = balance;
        if (amount <= balance){
            balance-=amount;
            System.out.printf("Starting balance: %.0f, withdraw amount (%.0f): new balance = %.0f%n", originalBalance, amount, balance);
        }else{
            System.out.printf("Starting balance: %.0f, withdraw amount (%.0f): INSUFFICIENT FUNDS!", originalBalance, amount);
        }


    }

}
