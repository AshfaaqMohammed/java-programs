package com.ListPractice;


/*

    stack follows - LIFO
    special implementation in stack -
        1. push
        2. pop
        3. peek - only gives the last element of stack.
        4. search
            search vs indexOf :
                search does searching from left to right (top to bottom)
                indexOf searches element from right to left (bottom to top)

 */

import java.util.Stack;

public class StackPractice {
    public static void main(String[] args){

        Stack<Integer> books = new Stack<>();
        books.push(1);
        books.add(2);
        books.push(3);
        System.out.println(books);
        System.out.println(books.indexOf(3));
        System.out.println(books.search(3));

        String name = "ashfaaq";

        StackPractice sp = new StackPractice();


    }
}
