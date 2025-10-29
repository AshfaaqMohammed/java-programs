package com.MultiThreading.Deadlock;

/*

    types of deadlock -
        1. intrinsic/monitor lock - any time we are using synchronization keyword or block, we are obtaining an intrinsic lock.
            limitations -
                1. There is not way to test if the intrinsic lock has already been acquired or not.
                2. There is no way to interrupt a blocked thread.
                3. there is not a easy way to debug or examine
                4. intrinsic lock is exclusive lock, means all other threads are blocked from acquiring other kind of lock.

         2. Explicit locks - uses Lock interface to explicitly lock the code and unlock the code.
            Lock interface -
                1. it is interface
                2. it is has 6 abstract methods which are mandatory to override.
                3. i.e - lock(), tryLock(), tryLock() [overloading method], lockInterruptibly(), unlock(), newCondition().

 */


import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MessageRepository{
    private String message;
    private boolean hasMessage = false;
    private final Lock lock = new ReentrantLock();

    public String read(){
        System.out.println("in read "+hasMessage);

        if (lock.tryLock()){
            try{
                while(!hasMessage){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                hasMessage = false;
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("**read blocked " + lock);
            hasMessage = false;
        }
        return message;
    }

    public void write(String message){
        System.out.println("in write "+hasMessage);
        if(lock.tryLock()){
            try{
                while (hasMessage){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                hasMessage = true;
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println("**writer blocked " + lock);
            hasMessage = true;
        }
        this.message = message;
    }
}

class messageWriter implements Runnable{

    private MessageRepository outGoingMessage;
    private final String text = """
            this is line1
            this is line2
            this is line3
            """;

    public messageWriter(MessageRepository outGoingMessage){
        this.outGoingMessage = outGoingMessage;
    }

    @Override
    public void run(){

        System.out.println("this is messageWriter - ");
        Random random = new Random();
        String[] lines = text.split("\n");

        for (int i=0;i<lines.length;i++){
            outGoingMessage.write(lines[i]);
            try{
                Thread.sleep(random.nextInt(500,2000));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        outGoingMessage.write("Finished");
    }
}

class MessageReader implements Runnable{

    private MessageRepository incomingMessage;

    public MessageReader(MessageRepository incomingMessage){
        this.incomingMessage = incomingMessage;
    }


    @Override
    public void run(){

        System.out.println("this is messageReader - ");
        Random random = new Random();
        String lastMessage = "";

        do {
            try{
                Thread.sleep(random.nextInt(500,2000));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            lastMessage = incomingMessage.read();
            System.out.println(lastMessage);
        }while (!lastMessage.equals("Finished"));
    }
}



public class  ConsumerProducer {
    public static void main(String[] args) {

        MessageRepository messageRepository = new MessageRepository();

        Thread reader = new Thread(new MessageReader(messageRepository),"Reader");
        Thread writer = new Thread(new messageWriter(messageRepository),"Writer");


        writer.setUncaughtExceptionHandler((thread,exc) -> {
            System.out.println("Writer had exception: " + exc);
            if (reader.isAlive()){
                System.out.println("Going ot interrupt the reader");
                reader.interrupt();
            }
        });

        reader.setUncaughtExceptionHandler((thread,exc) -> {
            System.out.println("Reader had exception: " + exc);
            if (writer.isAlive()){
                System.out.println("Going ot interrupt the writer");
                writer.interrupt();
            }
        });

        reader.start();

        writer.start();
    }
}
