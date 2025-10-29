package com.MultiThreading.ParallelStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    problem occur if you use non thread safe collections -
        1. Concurrent modification problem
        2. memory inconsistent problem

    Converting non thread safe colleciton to thread safe collection
        1. HashMap<> - > ConcurrentSkipListMap<>/ Collections.synchronizedMap(HashMap<>)
 */



record Person(String firstName, String lastName, int age){

    private final static String[] first = {"Able", "Bob", "Charlie", "Donna", "Eve", "Fred"};
    private final static String[] last = {"Norton", "OHara", "Petersen", "Quincy", "Richardson", "Smith"};

    private final static Random random = new Random();

    public Person(){
        this(first[random.nextInt(first.length)],
                last[random.nextInt(last.length)],
        random.nextInt(18,55));
    }

    @Override
    public String toString(){
        return "%s, %s (%d)".formatted(lastName, firstName, age);
    }
}

public class ParallelStreamsMain {
    public static void main(String[] args) {
        var persons = Stream.generate(()->new Person())
                .limit(10)
                .sorted(Comparator.comparing((Person person) -> person.lastName()))
                .toArray();

        for (var person : persons){
            System.out.println(person);
        }

        System.out.println("-".repeat(10));

        Arrays.stream(persons)
                .limit(10)
                .parallel()
//                .sorted(Comparator.comparing(Person::firstName)) using sorted in parallel streams is not best option.
                .forEachOrdered(System.out::println);

        System.out.println("-".repeat(10));

        String humptyDumpty = """
                Humpty Dumpty sat on a wall.
                Humpty Dumpty had a great fall.
                All the king's horses and all the king's men
                couldn't put Humpty together again.
                """;

        var words = new Scanner(humptyDumpty).tokens().toList();
//        System.out.println(Arrays.toString(words));



        // This below code will throw an error because it is not thread safe.

//        var backTogetherAgain = words.parallelStream()
//                .reduce(
//                        new StringJoiner(" "),
//                        StringJoiner::add,
//                        StringJoiner::merge
//                );
//        System.out.println(backTogetherAgain);


        // to make it thread safe - use .collect()
        var backTogetherAgain = words
                .parallelStream()
                .collect(Collectors.joining(" "));
        System.out.println(backTogetherAgain);


        Map<String, Long> lastNamesCounts =
                Stream.generate(Person::new)
                        .limit(10000)
                        .parallel()
                        .collect(Collectors.groupingByConcurrent(Person::lastName,Collectors.counting())); // we will use .groupingByConcurrent() when we are using non thread-safe collections.

        lastNamesCounts.entrySet().forEach(System.out::println);
    }

}
