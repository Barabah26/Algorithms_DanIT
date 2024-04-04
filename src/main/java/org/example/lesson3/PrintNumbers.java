package org.example.lesson3;

public class PrintNumbers {
    public static void main(String[] args) {
        printNumbers(5);
    }

    public static void printNumbers(int number){
        if (number == 0){
            return;
        }

        printNumbers(number - 1);
        System.out.print(number + " ");
    }
}
