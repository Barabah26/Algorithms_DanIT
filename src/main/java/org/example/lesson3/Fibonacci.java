package org.example.lesson3;

public class Fibonacci {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(fib(45));
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int fib(int number){
        if (number == 0){
            return 0;
        }
        if (number <= 2){
            return 1;
        }
        return fib(number - 1) + fib(number - 2);
    }
}

