package com.ListPractice;

import java.util.*;

/*

Important point to remember -

     1. what is the default capacity - 0
     2. what is the initial capacity - 10
     3. does it allow duplicate elements - yes
     4. does it allow null values - yes
     5. does it maintain the insertion order - yes
     6. does it maintain the sorted order - No
     7. does it offer the random access of elements - yes
     8. is it synchronised - No
     9. what is it good at - when data is not increased exponentially.

 */

public class ALPractice {
    public static void main(String[] args){
        List<Integer> al1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(al1);
        al1.add(4);
        al1.add(null);
        System.out.println(al1);
    }
}
