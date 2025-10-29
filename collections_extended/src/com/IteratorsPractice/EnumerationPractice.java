package com.IteratorsPractice;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationPractice {

    public static void main(String[] args){
        /*
        Enumeration - Interface
        Introduced for iterating the legacy collection objects
        legacy classes - v1.0 :
            HashTable, Stack, Vector, Dictionary and properties
        New classes - v1.2
         */

        Vector<String> vector = new Vector<>();
        vector.add("Sumith");
        vector.add("Adi");
        vector.add("Venkat");

        Enumeration<String> e = vector.elements();
        // e.hasMoreElements()
        // e.nextElement()
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}
