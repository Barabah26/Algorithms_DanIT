package org.example.lesson3;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(4));
    }

    public static int fact(int number){
        if (number <= 1){
            return 1;
        }
        return number * fact(number - 1);
    }
}
