package com.IteratorsPractice;

import java.util.ListIterator;
import java.util.Vector;

public class ListIteratorPractice {
    public static void main(String[] args){
        /*
        - ListIterator - Interface
        - Introduced for iterating only list type of collections
        - legacy classes - v1.0 + new classes-v1.2 (only which implements list)
        - bi direction, read and write ops.
         */

        Vector<Integer> vec = new Vector<>();
        vec.add(10);
        vec.add(20);
        vec.add(30);

        ListIterator<Integer> li = vec.listIterator();
        while (li.hasNext()){
            System.out.println(li.next());
        }

        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }
}
