package com.MultiThreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronisedCollections {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread one = new Thread(()->{
           for(int i=0;i<1000;i++){
               list.add(i);
           }
        });

        Thread two = new Thread(()->{
            for(int i=0;i<1000;i++){
                list.add(i);
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
