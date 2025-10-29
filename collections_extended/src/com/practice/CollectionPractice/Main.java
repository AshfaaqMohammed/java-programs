package com.practice.CollectionPractice;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        //1. find the product of all even numbers in a list.
        List<Integer> numbers = Arrays.asList(2,4,6,3);
        System.out.println(
                numbers.stream()
                        .filter(x->x%2==0)
                        .reduce((x,y)->x*y)
                        .get()
        );

        //2. concatenate all strings with a delimiter
        List<String> words = Arrays.asList("java", "streams", "reduce");
        System.out.println(
                words.stream()
                        .reduce((x,y)->x+" - "+y)
                        .get()
        );

        //3. Find the maximum number without useing max()
        List<Integer> nums = Arrays.asList(5,9,2,15,7);
        System.out.println(
                nums.stream()
                        .reduce((x,y)->{
                            return (x>y) ? x : y;
                        })
                        .get()
        );

        //4. Filter and count
        List<String> names =  Arrays.asList("Alice", "Bob", "Anna", "alex", "Mark");
        System.out.println(
                names.stream()
                        .peek(x-> System.out.println(x))
                        .filter(x->x.startsWith("a") || x.startsWith("A"))
                        .count()
        );

        //5. Transform and sort
        List<String> new_words = Arrays.asList("banana", "apple", "grape");
        List<String> result = new_words.stream()
                .map(x->x.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(result);

        //6. Find the square of distinct odd numbers
        List<Integer> new_nums = Arrays.asList(1, 2, 3, 3, 5, 6, 5);
        List<Integer> result6 = new_nums.stream()
                .distinct()
                .filter(x->x%2!=0)
                .map(x->x*x)
                .collect(Collectors.toList());
        System.out.println(result6);


        List<Integer> rev = Arrays.asList(1,2,88,52, 65, 11, 12, 12, 2);
//        rev.stream()
//                .filter((x)->{
//                    return (Collections.frequency(rev,x) > 1);
//                })
//                .distinct()
//                .forEach(x -> System.out.print(x+" "));
        System.out.println(
                rev.stream()
                        .reduce((x,y) -> {
                            return (x>y?x:y);
                        })
                        .get()
        );
        System.out.println(
                rev.stream()
                        .max(Comparator.naturalOrder())
                        .get()
        );
        System.out.println(
                rev.stream()
                        .peek(x-> System.out.println(x))
                        .filter(x->x==11)
                        .findFirst()
        );


        Map<String,Integer> map = new HashMap<>();
        map.put("ash",1);
        map.put("sumith",2);
        map.put("aman",3);
        map.put("srinija",4);
        map.put("naveen",5);

        for(Map.Entry<String,Integer> eles : map.entrySet()){
            System.out.println(eles.getKey() + " - " + eles.getValue());
        }

        System.out.println(
                rev.stream()
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        );

        rev.stream()
                .filter(x->x.toString().startsWith("1"))
                .forEach(System.out::println);

        String name = "ashfaaq";




//        Runnable runnable = ()->{
//            System.out.println("Ashfaaq");
//        };
//        Thread thread = new Thread(runnable,"LE_thread");
//        thread.start();
//
//        Thread thread1 = new Thread(new ChildThread("childThread"));
//        thread1.start();



    }

}

class NewThread{

    private String threadName;

    public NewThread(String threadName){
        this.threadName = threadName;
    }

    public String getName(){
        return this.threadName;
    }
}

class ChildThread extends NewThread implements Runnable{

    public ChildThread(String threadName){
        super(threadName);
    }

    @Override
    public void run(){
        System.out.println("this is child class thread - " + super.getName());
    }
}
