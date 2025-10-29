package com.MultiThreading.Synchronization;

/*
    - When one thread is executing a synchronized method for an object, all other threads that invoke synchronized methods for the same object are blocked, until the first thread is done with the object.
    - synchronized method ensures that the state of the object is visible to all threads.

    ** Teentrant Synchronization
        - when same thread calls multiple method which is locked(synchronized), it wont block, because current thread already has it. (it is basically a nested lock) this is called reentrant synchronozation.

    wait() - any code in synchronized method, thats sitting in a loop and waiting for something to change, should be calling the wait method.
            this will suspend its synchronozation that claims on the object, while thread waits for some condition to be met.
 */





public class Main {
    public static void main(String[] args) {

        BankAccount campanyBankAccount = new BankAccount(10000);

        Thread thread1 = new Thread(() -> {
            campanyBankAccount.withdraw(2500);
            System.out.println("this thread is - " + Thread.currentThread().getName());
        });
        Thread thread2 = new Thread(() -> {
            campanyBankAccount.deposit(5000);
            System.out.println("this thread is - " + Thread.currentThread().getName());

        });
        Thread thread3 = new Thread(() -> campanyBankAccount.withdraw(2500));
        Thread thread4 = new Thread(() -> campanyBankAccount.deposit(5000));

        thread1.run();
        thread2.start();
        thread3.run();
        thread4.run();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final Balance - " + campanyBankAccount.getBalance());
    }
}
