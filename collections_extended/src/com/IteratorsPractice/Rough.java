package com.IteratorsPractice;

import java.util.*;

public class Rough {
    public static void main(String[] args){

        List<Integer> list2 = new ArrayList<>(List.of(1,8,0,5,1,6));

        ListIterator<Integer> li = list2.listIterator();

        while(li.hasNext()){

            System.out.println(li.next());
        }




    }

}
