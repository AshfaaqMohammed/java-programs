package com.Streams;
import java.util.*;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        /*
        Intermediate operations -
            - These operations transform a stream into another stream
            - They are lazy, meaning they dont execute until a terminal operation is invoked.
         */

        //1. filter()
        List<Integer> list = Arrays.asList(5,1,2,4,3);
        Stream<Integer> filteredStream = list.stream()
                .filter(x->x%2==0);
        System.out.println(filteredStream.count());
        /*
        here until count is invoked, filter does not get executed. (count is a terminate ops).
         */

        System.out.println("-".repeat(10));

        //2. map()
        Stream<Integer> mappedStream = list.stream()
                .map((x) -> x*2);
        mappedStream.forEach(System.out::println);

        System.out.println("-".repeat(10));

        //3. sort()
        Stream<Integer> sortedStream = list.stream()
                .sorted();
        sortedStream.forEach(System.out::println);
        System.out.println("-".repeat(5));
        Stream<Integer> reverseSortedStream = list.stream()
                .sorted((a,b)->b.compareTo(a));
        reverseSortedStream.forEach(System.out::println);

        //4. distinct() - to get distinct element from collection
        System.out.println("-".repeat(10));
        //5. limit()
        Stream.iterate(1,x->x+1).limit(10)
                .forEach(x-> System.out.println(x));
        System.out.println("-".repeat(10));
        // skip()
        Stream.iterate(1,x->x+1).skip(5).limit(10)
                .forEach(x-> System.out.println(x));
    }
}
