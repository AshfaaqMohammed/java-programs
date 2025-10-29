package com.ListPractice;

import java.util.List;
import java.util.PriorityQueue;

/*
    important operations -
        addition - offer, add
        retrieval - peek
        removal - poll, remove
        difference between poll and remove is when pq is empty remove will throw an exception and poll will get the default value head i.e -null.


    - default array size of pq: 11
    - no nulls are allowed to add in pq.
    - duplicates are allowed.
    - lowest element in tha array have highest priority.
        * in pq there is something called head and tail, head
            always point the to the lowest element(highest priority).

            example - we added elements in the following - 8,2,5,7
                    then if we print result would be - 2,7,5,8


    Arraydeque :
        - default array size in arraydeque is 17.
        - difference between priority queue and arraydeque is in pq element deletion happens at first element
        and in arraydeque removal can be done from both first and last elements.
        - there is no priority order in arraydeque.
        - insertion order is maintained.
        - methods in arraydeque:
            addition - offer, offerFirst, offerLast, add, addFirst, addLast
            retrieval - peek, peekFirst, peekLast
            removal - poll, pollFirst, pollLast, remove, removeLast, removeFirst.

 */


public class QPractice {
    public static void main(String[] args){
        // Creation of priorityQueue
        Integer[] nums = {4,3,7,3};
        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(nums));
//        pq.offer(8);
//        pq.offer(2);
//        pq.offer(5);
//        pq.offer(7);
//        pq.offer(1);



        System.out.println(pq);

    }
}
