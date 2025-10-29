package com.MultiThreading.challenge;

public class ThreadChallenge {
    public static void main(String[] args) {
        CustomeChallengeThread evenThread = new CustomeChallengeThread();
        evenThread.start();

        Thread oddthread = new Thread(()->{
            int count = 0;
            int i = 1;
            while (count < 5){
                if (i % 2 != 0){
                    System.out.printf(" %d ".formatted(i));
                    count++;
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
                i++;
            }
        });
        oddthread.start();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        oddthread.interrupt();
    }
}
