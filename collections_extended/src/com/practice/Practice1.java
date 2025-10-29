package com.practice;

public class Practice1 {
    public static void main(String[] args) {

        Fish fish = new Fish("gold fish","water");
        fish.printable();
        fish.move();
        fish.hands();
        fish.run();

        Human.talk();

    }
}

abstract class Animal{
    String name;
    String type;

    public Animal(String name, String type){
        this.name = name;
        this.type = type;
    }

    abstract void move();

    public void printable(){
        System.out.println("Hi! iam " + this.name + " and iam " + this.type + " type" );
    }
}

class Fish extends Animal implements Human{
    public Fish(String name, String type) {
        super(name, type);
    }

    @Override
    public void move(){
        System.out.println("I swim fast.");
    }

    @Override
    public void run(){
        System.out.println("I cant run");
    }
}


interface Human{

    static void talk(){
        System.out.println("I can talk");
    }

    default void hands(){
        System.out.println("i have two hands");
    }

    abstract void run();

}
