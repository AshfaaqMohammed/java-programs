package com.Streams.Challenges.StreamingStudents;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC","Python master class", 50);
        Course jmc = new Course("JMC","Java master class",100);
        Course jgames = new Course("JGAME","Creating games in java");

        List<Students> students = IntStream
                .rangeClosed(1,5000)
                .mapToObj(s->Students.getRandomStudent(jmc,pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s->s.getPercentComplete("JMC"))
                .reduce(0,Double::sum);

        double avePercent = totalPercent / students.size();
        System.out.printf("Average percentage complete = %.2f%% %n",avePercent);

        int topPercent = (int) (1.25 * avePercent);
        System.out.printf("Best Percentage Complete = %d%% %n",topPercent);

        Comparator<Students> comparator = Comparator.comparing(Students::getYearEnrolled);

        List<Students> topStudents = students.stream()
                .filter(s->s.getMonthsSinceActive("JMC")==0)
                .filter(s->s.getPercentComplete("JMC") >= topPercent)
                .sorted(comparator)
                .limit(10)
                .toList();

        topStudents.forEach(s->{
            s.addCourse(jgames);
            System.out.print(s.getStudentId() + " ");
        });
        System.out.println();

        //upper code in just one liner -

        students.stream()
                .filter(s->s.getMonthsSinceActive("JMC")==0)
                .filter(s->s.getPercentComplete("JMC") >= topPercent)
                .sorted(comparator)
                .limit(10)
                .toList()
                .forEach(s->{
                s.addCourse(jgames);
                System.out.print(s.getStudentId() + " ");
            });
    }
}
