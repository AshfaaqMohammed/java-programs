package Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Rough {
    public static void main(String[] args) {

        Integer temp = 5;
        System.out.println(temp.compareTo(7));

        Student[] stu = {
            new Student("Adi"),
            new Student("Sumith"),
            new Student("Dukudu")
        };
        Arrays.sort(stu);
//        Arrays.asList(stu).sort(null);
        System.out.println(Arrays.toString(stu));
    }
}

class Student implements Comparable<Student>{
    private static int LAST_ID=0;
    private static Random random = new Random();

    private String name;
    private int id;
    private double gpa;

    public Student(String name){
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString(){
        return "%d-%s(%.2f)".formatted(id,name,gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Double.valueOf(gpa).compareTo(Double.valueOf(o.gpa));
    }


}
