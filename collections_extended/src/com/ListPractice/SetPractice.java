package com.ListPractice;

/*

    - HashSet uses hasmaps in the background.
    - hashset -> hasmap -> array of nodes(key, value)
    - key is the values enterd by user and value is a dummy object
        i.e - new Object();
    - there can be no duplicates.
    - no order is maintained.

    - Linkedhashset - maintains insertion order.
    - Treeset - maintains sorted order.
        * Treeset have additional methods like -
            1. first() - return first/lowest element
            2. last() - returns last/highest element
            3. pollFirst(),pollLast() - remove first and last element respectively.
            4. subset(range from , range to) - return elements in the from-to range in the treeset.
            5. any operations performed on ts.subset will effect on real treeset.

    Important points on Set -

    1. HashSet:
        Default capacity - 0
        Initial capacity - 16
        allow duplicates - no
        allow null values - yes
        insertion order - no
        sorted order - no
        random access - no
        synchronization - no
    2. LinkedHashSet:
        Default capacity - 16
        Initial capacity - 16
        allow duplicates - no
        allow null values - yes
        insertion order - yes
        sorted order - no
        random access - no
        synchronization - no

    3. TreeSet:
        Default capacity - 0
        Initial capacity - 0
        allow duplicates - no
        allow null values - no
        insertion order - no
        sorted order - yes
        random access - no
        synchronization - no

 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPractice {

    public static void main(String[] args){

        Set<Integer> ts = new HashSet<>();
        ts.add(2);
        ts.add(10);
        ts.add(23);
        ts.add(4);
        ts.add(100);
        System.out.println(ts);
//        Set<Integer> subset = ts.subSet(9,25);
//        subset.add(22);
//        System.out.println(subset);
//        System.out.println(ts);

    }


}

