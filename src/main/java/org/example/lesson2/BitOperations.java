package org.example.lesson2;

public class BitOperations {
    public static void main(String[] args) {
        int a = 10; //1010 в двійковій системі
        int b = 6;  //0110 в двійковій системі

        // Побітове І (AND)
        int andResult = a & b; // Результат: 2 (0010 в двійковій системі)
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(6));
        System.out.println("a & b = " + andResult);
        System.out.println(Integer.toBinaryString(andResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Побітове АБО (OR)
        int orResult = a | b;  // Результат: 14 (1110 в двійковій системі)
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(6));
        System.out.println("a | b = " + orResult);
        System.out.println(Integer.toBinaryString(orResult));

        System.out.println("-----------------------------------------------------------------------------------");


    }
}
