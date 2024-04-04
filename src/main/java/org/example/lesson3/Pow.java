package org.example.lesson3;

public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(5, 3));
    }

    public static int pow(int number, int power){
        if (power == 0){
            return 1;
        }
        if (power == 1){
            return number;
        }
        if (power < 0){
            throw new RuntimeException("Please input positive number " + power);
        }

        return number * pow(number, power - 1);
    }
}
