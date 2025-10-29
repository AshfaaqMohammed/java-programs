package Lambda_Expressions;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Adi",
                "Sumith",
                "aman",
                "venkat"
        ));

        for (String s : list){
            System.out.println(s);
        }

        System.out.println("-".repeat(10));

        list.forEach((s)->{
            System.out.println(s);
        });
        System.out.println("-".repeat(10));

        list.forEach((s -> {
            var f = s.charAt(0);
            System.out.println(s + " means " + f);
        }));

        System.out.println(doOperate((a,b)->(a+b),2,3));

        System.out.println("-".repeat(30));

        String mySentence = "Let' s split this up into an array.";

        doAccept((String sen) -> {
            String[] parts = sen.split(" ");
            Arrays.asList(parts).forEach((s)-> System.out.println(s));
        },mySentence);


        String source = "1234567890";

        var minChalAns = acceptDo((String sou) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i=0; i<sou.length(); i++){
                if (i%2 == 1){
                    returnVal.append(sou.charAt(i));
                }
            }
            return returnVal.toString();
        },source);

        System.out.println(minChalAns);

        Supplier<String> iLoveJava = ()->" I Love Java";
        System.out.println(iLoveJava.get());

        String[] firstname = {"Adi", "sumith", "Venkat", "anna"};
        Arrays.setAll(firstname, i-> firstname[i].toUpperCase(Locale.ROOT));
        Arrays.asList(firstname).forEach(System.out::println);

        record Person(String firstName, String lastName){ }

        List<Person> personList = new ArrayList<>(List.of(
                new Person("rahul","reddy"),
                new Person("Abhi","chowdary"),
                new Person("Sri","yelamanchali")
        ));
        personList.sort(Comparator.comparing(Person::lastName));

        personList.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName));

        personList.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName).reversed());
        System.out.println(personList);


        List<Integer> temp = new ArrayList<>(List.of(1,3,5,2,4,7));
        temp.sort(Comparator.reverseOrder());








    }

    public static <T> T doOperate(Operations<T> myOp,T value1, T value2){
        return myOp.operate(value1,value2);
    }

    public static <T> void doAccept(MiniChallenge1<T> miniChal, String sentence){
        miniChal.accept(sentence);
    }

    public static <T> T acceptDo(MiniChallenge2<T> miniChal2, String source){
        return miniChal2.accept(source);
    }
}
