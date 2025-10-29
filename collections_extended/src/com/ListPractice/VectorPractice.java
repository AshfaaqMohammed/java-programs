package com.ListPractice;
import java.io.FileReader;
import java.util.*;

/*
    Major Operations in collections -
        1. Creation of a list
        2. addition of elements into the list
            * adding one element
            * adding a list into another list
        3. Retrieval of elements from the list
        4. Deletion of elements from the list
        5. verification of elements in the list
        6. Updation of elements in the list.


     ---------------------------------------------------

     Important point to remember -

     1. what is the default capacity - 10
     2. what is the initial capacity - 10
     3. does it allow duplicate elements - yes
     4. does it allow null values - yes
     5. does it maintain the insertion order - yes
     6. does it maintain the sorted order - No
     7. does it offer the random access of elements - yes
     8. is it synchronised - yes
     9. what is it good at - multi threading, when data is increased exponentially.
 */
public class VectorPractice {
    public static void main(String[] args) {
        Vector v1 = new Vector();

        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");
        v1.add("sumith");




        System.out.println("Size - " + v1.size());
        System.out.println("Capacity - " + v1.capacity());




    }
}
