package com.practice.DeadLockPractice;

import java.util.Arrays;
import java.util.TreeMap;

public class IntrinsicLock {
    public static void main(String[] args) {

        String[] arr = "ashfaaq".split("");
        System.out.println(Arrays.toString(arr));

        Object obj1 = new Object();
        Object obj2 = new Object();


        Thread thread1 = new Thread(()->{
            synchronized (obj1){
                System.out.println("thread1 locked obj1");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
                synchronized (obj2){
                    System.out.println("thread1 locked obj2");
                }
            }
        },"T1");

        Thread thread2 = new Thread(() -> {
            synchronized (obj2){
                System.out.println("Thread2 locked Obj2");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
                synchronized (obj1){
                    System.out.println("Thread2 locked obj1");
                }
            }
        },"T2");

        thread1.start();
        thread2.start();
    }
}
