package com.practice;

import java.util.Arrays;
import java.util.List;

public class Volatile {
    private static int counter = 0;
    private static Object lock = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            for (int i=0;i<10000;i++){
                synchronized (lock){
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            for (int i=0;i<10000;i++){
                synchronized (lock){
                    counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
