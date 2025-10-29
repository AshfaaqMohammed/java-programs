package com.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()){
            for (int i=start;i<start+15;i++){
                bingoPool.add("" + c + i);
            }
            start+=15;
        }

//        System.out.println(bingoPool);
//        Collections.shuffle(bingoPool);

        var bStream = Stream.iterate(1,x->x+1)
                .limit(15)
                .map(x->"B"+x);

        bStream.forEach(System.out::println);





//
//        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0,15));
//        firstOnes.sort(Comparator.naturalOrder());
//        System.out.println(firstOnes);
//        firstOnes.replaceAll((s)->{
//            if (s.indexOf('G') == 0 || s.indexOf('O') == 0){
//                String updated = s.charAt(0) + "-" + s.substring(1);
//                System.out.print(updated + " ");
//                return updated;
//            }
//            return s;
//        });
//        System.out.println("\n");
//        System.out.println("-".repeat(50));
//
////        System.out.println(bingoPool);
//
//        bingoPool.stream()
//                .limit(15)
//                .filter(s->s.indexOf('G') == 0 || s.indexOf('O') == 0)
//                .map(s -> s.charAt(0) + "-" + s.substring(1))
//                .sorted()
//                .forEach(s -> System.out.print(s + " "));
//
//
//        for (int i = 0;i<=15;i++){
//            System.out.println(bingoPool.get(i));
//        }
//
//        System.out.println("-".repeat(50));
//
//        //Streams with arrays
//        String[] strings = {"One","Two","Three"};
//        Arrays.stream(strings)
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);
//
//        // direct use of stream
//        Stream.of("Six","Five","Four")
//                .map(s->s.toUpperCase())
//                .forEach(System.out::println);
//
////        Stream.concat()
//
//
//        Map<Character, int[]> myMap = new HashMap<>();
//        int bingoIndex = 1;
//
//        for (char c : "BINGO".toCharArray()){
//            int[] numbers = new int[15];
//            int labelNo = bingoIndex;
//            Arrays.setAll(numbers,i ->i+labelNo);
//            myMap.put(c, numbers);
//            bingoIndex+=15;
//        }
//
//        for(char c : "BINGO".toCharArray()){
//            System.out.println(Arrays.toString(myMap.get(c)));
//
//        }
    }
}
