package com.Streams;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        /*
        ParallelStreams -
            a type of stream that enables parallel processing of elements,
            allowing multiple threads to process parts of the stream simultaneously
            this can significantly improve performance for large data sets

         */

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1,x->x+1).limit(20000).toList();
        List<Long> factorialList = list.stream()
                .map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by the code - "+ (endTime-startTime) + "ms");


        //now using parallelStream

        startTime = System.currentTimeMillis();
        factorialList = list.parallelStream()
                .map(ParallelStream::factorial)
                .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by the code - "+ (endTime-startTime) + "ms");


    }

    private static long factorial(int n){
        long fac = 1;
        for (int i=1;i<=n;i++){
            fac*=i;
        }
        return fac;
    }
}
