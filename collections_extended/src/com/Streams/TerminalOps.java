package com.Streams;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);

        //1. collect()
        List<Integer> streamdList = list.stream()
                .collect(Collectors.toList()); //return mutable list
        List<Integer> streamdList2 = list.stream()
                .toList(); // returns immutable list.
        // above both are valid.

        //2. forEach
        list.stream().forEach(System.out::println);

        //3. reduce() - Combines elements to produce a single result.
        System.out.println(
                list.stream()
                        .reduce((x,y)->x+y)
                        .get()
        );

        //4. count()

        //5. anyMatch, allMatch, noneMatch
        boolean b = list.stream().anyMatch(x->x%2==0);
        System.out.println(b);

        boolean b1 = list.stream().allMatch(x->x>0);
        System.out.println(b1);

        boolean b3 = list.stream().noneMatch(x->x>6);
        System.out.println(b3);

        //6. findFirst, findAny


        System.out.println("-".repeat(50));
        //Examples -
        // 1. find name which has length greater than 3.
        List<String> names = Arrays.asList("Anna","bob","charlie","david");
        names.stream()
                .filter(x->x.length()>4)
                .forEach(System.out::println);

        System.out.println("-".repeat(25));

        //2. Squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(5,2,9,1,6);
        System.out.println(
                numbers.stream()
                        .map(x->x*x)
                        .sorted(Comparator.reverseOrder())
                        .toList()
        );

        System.out.println("-".repeat(25));

        //3. summing values
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        System.out.println(integers.stream()
                .reduce((x,y)->x+y).get());

        System.out.println("-".repeat(25));

        //4. counting occurrences of a character
        String sentence = "Hello world";
        System.out.println(sentence.chars()
                .filter(x->x=='l')
                .count()
        );
        System.out.println("-".repeat(50));

        /*
        Grouping elements -
         */

        List<String> words = Arrays.asList("hello","world","java","streams","collecting");

        System.out.println(
                words.stream()
                        .collect(Collectors.groupingBy(String::length))
        );
        System.out.println(
                words.stream()
                        .collect(Collectors.groupingBy(String::length, Collectors.joining(", ")))
        );

        System.out.println(
                words.stream()
                        .collect(Collectors.groupingBy(String::length,Collectors.counting()))
        );

        System.out.println(
                String.valueOf(words.stream()
                        .collect(Collectors.groupingBy(String::length, TreeMap::new,Collectors.counting())))
        );

        // example - counting word occurrences

        String sentence0 = "hello world hello java world";
        System.out.println(
                Arrays.stream(sentence0.split(" "))
                        .collect(Collectors.groupingBy(x->x, Collectors.counting()))
        );

        // Example - partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(
                l2.stream()
                        .collect(Collectors.partitioningBy(x->x%2==0))
        );


        //Example - creating a map from stream elements
        List<String> fruits = Arrays.asList("Apple","Banana","Cherry");
        System.out.println(
                fruits.stream()
                        .collect(Collectors.toMap(x->x, String::length))
        );

        List<String> words2 = Arrays.asList("apple","banana","apple","orange","banana","apple");
        System.out.println(
                words2.stream()
                        .collect(Collectors.toMap(k->k,v->1,(x,y)->x+y))
        );


    }
}
