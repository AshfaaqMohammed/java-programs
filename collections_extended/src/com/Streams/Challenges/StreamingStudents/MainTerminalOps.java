package com.Streams.Challenges.StreamingStudents;

import javax.crypto.spec.PSource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
this file tells about terminal ops for Optional type, if Optional intermidiate ops are used.
    terminal ops example -
        1. .ifPresent()
        2. .ifPresentOrElse()

    intermidiate ops example -
        1. .min()
        2. .max()
        3. .average()
        4. .findFirst(), .findAny()
        5. .reduce()
        etc..
 */

public class MainTerminalOps {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC","Python master class");
        Course jmc = new Course("JMC","Java master class");

        List<Students> students = Stream.generate(()->Students.getRandomStudent(jmc,pymc))
                .limit(1000)
                .toList();

        int minAge = 21;
        students.stream()
                .filter(s->s.getAge()<=21)
                .findAny()
                .ifPresentOrElse(s-> System.out.println(s.getStudentId() + " " + s.getAge()), ()-> System.out.println("Did not find any student"));

        //Better way to use it - using .min(comparator)
        students.stream()
                .filter(s->s.getAge()<=21)
                .min(Comparator.comparing(Students::getAge))
                .ifPresentOrElse(s-> System.out.println(s.getStudentId() + " " + s.getAge()), ()-> System.out.println("Did not find any student"));
    }
}
