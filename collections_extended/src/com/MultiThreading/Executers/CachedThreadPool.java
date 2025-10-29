package com.MultiThreading.Executers;

/*
    CachedThreadPool will creates as many threads as required for the submitted task.
        1. if a thread is available for executing the task, it will use the thread to execute
        2. if no thread is available for executing the task, then CachedThreadPool will create a new thread to execute the task.
        3. there is no concept called threadqueue
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i=0;i<100;i++){
            service.execute(new TaskOne(i));
        }
    }
}

class TaskOne implements Runnable{
    private final int taskId;

    public TaskOne(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println("Task: " + taskId + " beging executed by " + Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
