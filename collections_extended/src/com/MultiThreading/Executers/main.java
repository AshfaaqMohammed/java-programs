package com.MultiThreading.Executers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/*
    An Executors thread pool consists of three components.
        1. worker threads -
            * available in pool to execute tasks.
            * they are alive throughout the lifetime of the application.
        2. Submitted Tasks -
            * are placed in First-In First-Out queue.
        3. Thread pool Manager -
            * allocates tasks to threads, and ensures proper thread synchronization.

    Difference between Runnable and Callable -
        1. Runnable is functional method                1. Callable is Functional method
        2. void run()                                   2. v Call() throws Exception
        3. does not return any value                    3. returns a value.

    Executor.execute Vs Executor.signature
        1. execute - void execute(Runnable command), does not return a value.
        2. submit - has 2 overloading methods, which return a value.
 */


class ColorThreadFactory implements ThreadFactory{
    private String threadName;
    private int colorValue=1;


    public ColorThreadFactory(ThreadColor color){
        this.threadName = color.name();
    }

    public ColorThreadFactory(){

    }

    @Override
    public Thread newThread(Runnable r){
        Thread thread = new Thread(r);
        String name = threadName;

        if (name == null){
            name = ThreadColor.values()[colorValue].name();
        }
        if (++colorValue > (ThreadColor.values().length-1)){
            colorValue = 1;
        }
        thread.setName(name);
        return thread;
    }
}


public class main {
    public static void main(String[] args) {
        int count = 3;
        var multiExecutor = Executors.newFixedThreadPool(
                count,new ColorThreadFactory()
        );
        for (int i=0;i<count;i++){
            multiExecutor.execute(main::countDown);
        }
        multiExecutor.shutdown();
    }


    public static void singleMain(String[] args) {

        var blueExecutor = Executors.newSingleThreadExecutor(new ColorThreadFactory(ThreadColor.ANSI_BLUE));
        blueExecutor.execute(main::countDown);
        blueExecutor.shutdown();
        boolean isDone = false;
        try{
            isDone = blueExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (isDone){
            System.out.println("blue finished, starting yellow");
            var YellowExecutor = Executors.newSingleThreadExecutor(new ColorThreadFactory(ThreadColor.ANSI_YELLOW));
            YellowExecutor.execute(main::countDown);
            YellowExecutor.shutdown();
        }

    }

    private static void countDown(){
        String threadName = Thread.currentThread().getName();
        var threadColor = ThreadColor.ANSI_RESET;
        try{
            threadColor = ThreadColor.valueOf(threadName.toUpperCase());
        }catch (IllegalArgumentException ignore){

        }
        String color = threadColor.color();
        for(int i=20; i>=0;i--){
            System.out.println(color + " " + threadName.replace("ANSI_","") + " " + i);
        }
    }
}
