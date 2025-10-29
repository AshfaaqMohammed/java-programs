package com.IteratorsPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPractice {
    public static void main(String[] args){
        /*
        - Iterator - Interface
        - Introduced for iterating all collection objects
        - Legacy classes -v1.0 + new classes - v1.2
        - one direction, read-only with special permission for removing elements.
        - it is not possible to directly use on classes which implements map interfaces.
         */

        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(40);

        Iterator<Integer> ite = list.iterator();

        //mehtods -
        // 1. ite.hasNext()
        // 2. ite.next()

        while (ite.hasNext()){
            System.out.println(ite.next());
        }


    }
}
