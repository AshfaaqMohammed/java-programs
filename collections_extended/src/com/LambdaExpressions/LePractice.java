package com.LambdaExpressions;

public class LePractice {
    public static void main(String[] args){

        //anonymous class
        car bmw = new car() {
            public void drive(){
                System.out.println("driving bmw");
            }
        };
        bmw.drive();

        //Lambda expression
        /*
        components in lambda expressions -
            argument list, arrow token, function body
         */
        car c1 = () ->{
            int num = 10;
            System.out.println("driving merc");
            System.out.println(num);
        };
        c1.drive();

        audi audi = new audi();
        audi.drive();
    }
}

class audi implements car{
    public void drive(){
        System.out.println("Driving audi.");
    }
}

@FunctionalInterface
interface car{
    void drive();
}
