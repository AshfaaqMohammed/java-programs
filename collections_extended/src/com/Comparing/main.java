package com.Comparing;

import java.util.*;

public class main {
    public static void main(String[] args){


//        int[] array = {2,5,4,1,6,4,8};
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));

        Comparator<Integer> comparator = new Comparator<Integer>(){

            public int compare(Integer o1, Integer o2){
                int result = Integer.compare(
                        o1,o2
                );
                return result;
            }
        };

        Comparator<Student> name_comperator = (Student n1, Student n2) -> {
            int result = Integer.compare(n2.marks,n1.marks);
            if (result == 0){
                result = n1.name.compareTo(n2.name);
            }
            return result;
        };
        Comparator<Student> marks_comperator = (Student n1, Student n2) -> Integer.compare(n1.marks,n2.marks);

        List<Integer> list = new ArrayList<>(List.of(2,5,4,1,6,4,8));
        Collections.sort(list,Comparator.naturalOrder());
        System.out.println(list);


        List<Student> students = new ArrayList<>(List.of(
                new Student("Adi",90),
                new Student("Sumith",95),
                new Student("venkat",90),
                new Student("Abhijeet",95)
        ));
        Collections.sort(students,name_comperator);
        System.out.println(students);

        int[] original = {1, 2, 3};
        int[] shallowCopy = original.clone();

        String[] originals = {"A","B","C"};
        String[] shollowCopys = originals.clone();
//
        shollowCopys[0] = "D";
        System.out.println(Arrays.toString(originals));
        System.out.println(Arrays.toString(shollowCopys));

//        String[] deepCopy = new String[3];
//        for (int i=0;i<originals.length;i++){
//            deepCopy[i] = new String(originals[i]);
//        }
//
//        deepCopy[0] = "D";
//
//        System.out.println(Arrays.toString(deepCopy));

        System.out.println("-".repeat(10));


        shallowCopy[0] = 99;

        System.out.println(original[0]);
        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(shallowCopy));


    }
}

class Student implements Comparable<Student>{
    String name;
    int marks;

    Student (String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.marks;
    }

    @Override
    public int compareTo(Student s1){
        int result = Integer.compare(s1.marks,this.marks);
        if (result == 0){
            result = s1.name.compareTo(this.name);
        }
        return result;
    }

}
