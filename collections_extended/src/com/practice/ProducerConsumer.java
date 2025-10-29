package com.practice;

import java.util.*;

public class ProducerConsumer {
    public static void main(String[] args) {
        Worker worker = new Worker(5,0);

        Thread producer = new Thread(()->{
            try {
                worker.producer();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });


        Thread consumer = new Thread(()->{
            try {
                worker.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
class Worker{
    private int sequence = 0;
    private final Integer top;
    private final Integer bottom;
    private final ArrayDeque<Integer> container;
    private final Object lock = new Object();

    public Worker(Integer top, Integer bottom){
        this.top = top;
        this.bottom = bottom;
        this.container = new ArrayDeque<>();
    }

    public void producer() throws InterruptedException{
        synchronized (lock){
            while (true){
                if (container.size() == top){
                    System.out.println("Container full, waiting for items to be removed....");
                    lock.wait();
                }else{
                    System.out.println(sequence + " added to container");
                    container.add(sequence);
                    sequence++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException{
        synchronized (lock){
            while(true){
                if(container.size() == bottom){
                    System.out.println("Container empty, waiting for items to be added..");
                    lock.wait();
                }else {
                    System.out.println(container.removeFirst() + " removed from the container");
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
