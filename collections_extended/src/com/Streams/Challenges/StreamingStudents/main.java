package com.Streams.Challenges.StreamingStudents;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC","Python master class");
        Course jmc = new Course("JMC","Java master class");
//
//        Students sumith = new Students("IND",2019,22,"M",true, pymc,jmc);
//        System.out.println(sumith);
//
//        sumith.watchLecture("JMC",5,6,2023);
//        sumith.watchLecture("PYMC",33,4,2025);
//
//        System.out.println(sumith);
//
//        Stream.generate(()->Students.getRandomStudent(jmc,pymc))
//                .limit(10)
//                .forEach(System.out::println);

        List<Students> list = Stream.generate(()->Students.getRandomStudent(jmc,pymc))
                .limit(5000)
                .toList();

        System.out.println(list.stream()
                .filter((student) -> student.getGender() == "M")
                .count());

        System.out.println(list.stream()
                .filter((student) -> student.getGender() == "F")
                .count());

        System.out.println(
            list.stream()
                    .filter((students -> students.getAge() <= 21))
                    .count()
        );

        System.out.println(
                list.stream()
                        .filter((students -> (students.getAge() > 21 && students.getAge() <= 25)))
                        .count()
        );

        System.out.println(
                list.stream()
                        .filter((students -> (students.getAge() > 25 && students.getAge() <= 28)))
                        .count()
        );

        var ageStream = list.stream().mapToInt(Students::getAgeEnrolled);
        System.out.println(ageStream.summaryStatistics());

        //get country codes
        list.stream()
                .map(Students::getCountryCode)
                .distinct()
                .forEach(System.out::println);
    }
}
