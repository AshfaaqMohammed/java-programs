package com.MultiThreading;

/*

    Concurrency Vs Parallelism
        1. concurrency means doing multiple things all at once by quickly switching between the tasks.
        2. Parallelism is doing multiple things at once by having different parts of the task been done simultaneously by different entities.


    About MultiThreading -
        1. Process - it is a unit of execution, that had its own memory space.
        2. process and application are often used interchangeably.
        3. each process/application has its own memory space called as HEAP
        4. the heap isn't shared between two applications/processes they have their own.

    Thread -
        1. A thread is a single unit of execution, with in the process
        2. each process can have multiple threads
        3. every application/process have at least one thread, which is known as main thread
        4. our code will run on the main thread
        5. we can also have our code run in other threads, which we can explicitly create and start
        6. each threads got what's called a thread stack
        7. this is memory, that only a single thread will have access to.

    Daemon Thread - Daemon threads are intended to be helper threads which run in the background and are low priority. EX - GC thread.

    - Creating a thread doesnt require as many resources as creating a process does.
    - every thread created by a process, shares that process's memory space i.e heap
    - this can cause big problems with the application
    - Every java application runs as a single process, and each process can then have multiple threads within it.

    Concurrency -
        1. concurrency refers to an application doing more than one thing at a time.
        2. concurrency allows different part of a program to make progress independently, often leading to better resource utilization and improved performance
        3. one task doesnt have to complete before another one can start, and multiple threads can make incremental progress


                                     Runnable
                              <<Functional Interface>>
                                        |
                                        |
                                        |
                                  Thread(implements)
                                 (Thread is a class)


        Thread priority
            1. thread priority is value from 1 to 10
            2. thread class has three pre-defined priorities, included as contants.
                - Thread.MIN_PROPERTY = 1 (low)
                - Thread.NORM_PROPERTY = 5 (default)
                - Thread.MAX_PROPERTY = 10 (high)
            3. Higher priority threads have a better chance of being scheduled, by a thread scheduler.


        - Synchronously = run sequentially
        - Asynchronously = run parallelly
        - There is difference between run() and start()
            - if you execute the run method, run will not create or invoke new thread instead run from the main thread.
            - if you want your code to be run asynchronously, you must call the start method

        - Memory:-
                ** check threadAccessPic.png for how thread has stack memory on its own and can access head**


        - Time Slicing:-
            - Time slicing is also known as time-sharing or time division.
            - Its a technique used in multitasking operating systems, to allow multiple threads/processes to share a single cpu for execution.
            - Available CPU time is sliced into small time intervals, which are divided out to the threads.
            - each thread gets the interval, to attempt to make some progress, on the task it has to do.
            - whether it completes its task or not, if time slice is up, then it has to yield to another thread and wait until its turn again.
            - so if threads are sharing heap memory, things can change during that wait.

        - Java Memory Model(JMM)
            - it is a specification that defines some rules and behaviours for threads, to help control and manage shared access to data and operations.

        - What is the meaning of THREAD-SAFE? :-
            1. a code block is thread safe, if it isnt compromised by the execution of concurrent threads.
                that means - correctness and consistency of the program output is not affected by other threads.
            2. atomic operations and immutable objects are examples of thread-safe code.


        - VOLATILE :-
            - it is keyword used as a modifier for class variables
            - it is an indicator that this variables value may be changed by multiple threads.


        Life Cycle of thread -
            0. New
            1. Running
            2. Blocked
            3. Waiting (.join())
            4. Waiting (specific time/sleep)
            5. Terminated



        Difference between countdown latch and join -
            1. CD latch is usefull when you have multi threads performing independent tasks and you want to coordinate with them before moving forward
            2. join is usefull when you have main thread that respawns worker threads and needs to wait for it to complete.


        Atomic and non atomic variables -
            1. non-atomic variables - which follow read-modify-write cycle.
            2. atomic variables are type of variables that support lock free thread safe ops. (it prevents lock conditions)

 */


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread);
        printThreadState(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start();

        Runnable myRunnable = ()->{
          for(int i=0;i<8;i++){
              System.out.println(" 2 ");
              try{
                  TimeUnit.MICROSECONDS.sleep(250);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
          }
        };

        Thread newThread = new Thread(myRunnable,"Runnalbe_Thread");
        newThread.start();
        printThreadState(newThread);

        for (int i=0;i<=3; i++){
            System.out.println(" 0 ");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        customThread.setName("customeThread");
        printThreadState(customThread);
    }
    public static void printThreadState(Thread thread){
        System.out.println("-".repeat(20));
        System.out.println("Thread ID - " + thread.getId());
        System.out.println("Thread name - " + thread.getName());
        System.out.println("Thread priority - " + thread.getPriority());
        System.out.println("Thread state - " + thread.getState());
        System.out.println("Thread group - " + thread.getThreadGroup());
        System.out.println("Thread is alive - " + thread.isAlive());
        System.out.println("-".repeat(20));

    }
}
