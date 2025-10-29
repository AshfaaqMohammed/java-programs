package com.Streams;

import java.net.Inet4Address;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EngDigestStreams {
    public static void main(String[] args){

        // **Lambda Expression.

        // Predicate ---> Functional interface (Boolean valued function)
        //      1. default function = .test()[return boolean value.]
        //      2. takes input and give boolean value as output.

        Predicate<Integer> isEven = x-> x%2 == 0;
        System.out.println(isEven.test(4));

        Predicate<String> isStratWithA = x -> x.toUpperCase().startsWith("S");
        System.out.println(isStratWithA.test("Sumith"));
        System.out.println(isStratWithA.test("surya"));

        Predicate<String> isEndingWithY = x->x.toLowerCase().endsWith("y");
        System.out.println(isEndingWithY.test("Sanay"));

        Predicate<String> and = isStratWithA.and(isEndingWithY);
        System.out.println(and.test("Sanay"));


        //Function --> does some work to give a response
        //      1. default function = .apply()
        //      2. takes input and give out response

        Function<Integer, Integer> doubleIt = x -> x*2;
        System.out.println(doubleIt.apply(4));
        Function<Integer,Integer> tripleIt = x -> x*3;
        System.out.println(doubleIt.andThen(tripleIt).apply(3)); // first doubleIt will act and then tripleIt will act
        System.out.println(doubleIt.compose(tripleIt).apply(3)); // here first tripleIt will act and then doubleIt will act.


        //Consumer --> does some work and does not return anything. (preferably used for printing)
        //      1. default function = .accept()
        //      2. takes input and does not return anything

        Consumer<Integer> print = (x) -> System.out.println(x);
        print.accept(10);

        List<Integer> list = List.of(1,2,3,4,5);
        Consumer<List<Integer>> printList = (x) -> {
            for (int i : x){
                System.out.print(i + " ");
            }
        };
        printList.accept(list);


        //Supplier
        //      1. default function = .get()
        //      2. will not take any input but give some output.

        Supplier<String> giveHelloWorld = () -> "\nHello World";
        System.out.println(giveHelloWorld.get());


        //Combined example
        Predicate<Integer> predicate = (x) -> x%2 == 0;
        Function<Integer, Integer> function = (x) -> x*x;
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        Supplier<Integer> supplier = () -> 20;


        if (predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

        System.out.println("-".repeat(50));


    }
}
