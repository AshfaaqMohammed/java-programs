package com.MultiThreading;

public class CheckPriority {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
            System.out.println("this is thread 1, low priority");
        });

        Thread thread2 = new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
            System.out.println("this is thread 2, norm priority");
        });

        Thread thread3 = new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
            System.out.println("this is thread 3, high priority");
        });

        thread1.setPriority(1);
        thread1.start();

        thread2.setPriority(5);
        thread2.start();

        thread3.setPriority(10);
        thread3.start();



    }
}
