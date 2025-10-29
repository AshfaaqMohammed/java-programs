package com.MultiThreading;

public class RunningThreads {
    public static void main(String[] args) {
        System.out.println("Main thread running");
        try{
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Thread thread = new Thread(()->{
           String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 dots to run.");
            for(int i=0;i<10;i++){
                System.out.print(" . ");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("\n" + tname + " completed");
        });
        System.out.println("\n" + thread.getName() + "  starting");
        thread.start();
        System.out.println("Main thread would continue here");
    }
}
