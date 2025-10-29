package com.practice.DeadLockPractice;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLock {

    public static void main(String[] args) {

       Lock lock1 = new ReentrantLock();
       Lock lock2 = new ReentrantLock();

        Thread thread1  = new Thread(()->{
            lock1.lock();
            try{
                System.out.println("Thread 1 locked lock1");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException w){
                    w.printStackTrace();
                }
                lock2.lock();
                try{
                    System.out.println("thread 1 locked lock2");
                }finally {
                    lock2.unlock();
                }
            }
            finally {
                lock1.unlock();
            }
        });


        Thread thread2 = new Thread(()->{
           lock2.lock();
           try {
               System.out.println("thread 2 locked lock2");
               try {
                   Thread.sleep(1000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               lock1.lock();
               try {
                   System.out.println("thread 1 locked lock1");
               }finally {
                   lock1.unlock();
               }
           }finally {
               lock2.unlock();
           }
        });

        thread1.start();
        thread2.start();

    }
}
