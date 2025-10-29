package com.Streams;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args){
        /*
        Streams -
            1. feature introduced in java 8
            2. process collections of data in a functional and declarative manner
            3. simplify data processing
            4. embrace functional programming
            5. improve readability and maintainability
            6. enable easy parallelism.
         */

        /*
        Way of creating Streams
            1. from collections
                Example -
                    List<Integer> list = Arrays.asList(2,3,4,5);
                    list.stream();
            2. From Arrays
                Example -
                    String[] array = {"a","b","c"};
                    Stream<String> stream = Arrays.stream(array);
            3. using Streams.of()
                Example -
                    Stream<String> stream2 = Stream.of("a","b");
            4. Infinite Streams
                Example -
                    Stream<Integer> generate = Stream.generate(() -> 1);
                    Stream.iterate(1,x->x+1).limit(100).collect(Collectors.toList());
         */



        //** Streams :

        //1. how stream is solving the problem in much more easy and readable way.
        // problem - count number of even number in list.

        //Traditional way -
        List<Integer> nums = List.of(1,2,3,4,5);

        int count = 0;
        for(int ele : nums){
            if (ele % 2 == 0){
                count++;
            }
        }
        System.out.println(count);

        //Using streams -
        System.out.println(nums.stream()
                .filter(x->x%2 == 0)
                .count());
    }
}
