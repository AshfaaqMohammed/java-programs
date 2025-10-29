package com.Generics;

import java.util.Arrays;

public class main {
    public static void main(String[] args){

        Almond indAlmond = new Almond("Indian Almonds");
        Almond nzAlmond = new Almond("Newzland almond");

        Box<Almond> almondBox = new Box<>(10);
        almondBox.add(indAlmond);
        almondBox.add(nzAlmond);

        System.out.println(Arrays.toString(almondBox.dryFruits));
        System.out.println(almondBox.get(0));

        main ma = new main();
        ma.temp();


        main.swap("hello","world");


    }
    // generic method -
    public static <T> void swap(T i, T j){
        System.out.println("i - " + i + " ," + "j - "+ j);
        T temp = i;
        i = j;
        j = temp;
        System.out.println("i - " + i + " ," + "j - "+ j);
    }
    public void temp(){
        System.out.println("temp");
    }
}

class Almond{
    String name;
    public Almond(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}

class Box<T>{
    T[] dryFruits;
    int index = 0;

    public Box(int size){
        dryFruits = (T[]) new Object[size];
        index = 0;
    }

    public void add(T dryFruit){
        dryFruits[index] = dryFruit;
        index++;
    }

    public T get(int ind){
        return dryFruits[ind];
    }
}
