package com.MultiThreading.Executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPool {
    public static void main(String[] args) {
        Thread task1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " started");
            for(int i=0;i<5;i++){
                try{
                    System.out.println("num = " + i);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"ashTask");

        Thread task2 = new Thread(()->{
            Thread.currentThread().setName("adilTask");
            System.out.println(Thread.currentThread().getName() + " started");
            for(int i=5;i<10;i++){
                try{
                    System.out.println("num = " + i);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        },"oldtask");


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0;i<1;i++){
            executorService.execute(task1);
            executorService.execute(task2);
        }
        System.out.println(task2.getName());
        executorService.shutdown();
    }
}
