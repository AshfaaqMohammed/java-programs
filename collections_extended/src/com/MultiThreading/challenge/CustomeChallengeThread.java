package com.MultiThreading.challenge;

public class CustomeChallengeThread extends Thread{

    public void run(){
        int count = 0;
        int i = 1;
        while (count < 5){
            if (i % 2 == 0){
                System.out.printf(" %d ".formatted(i));
                count++;
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();

                }
            }
            i++;
        }
    }

}
