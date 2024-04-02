package org.example.lesson2;

public class BitOperations {
    public static void main(String[] args) {
        int a = 10; //1010 в двійковій системі
        int b = 6;  //0110 в двійковій системі

        // Побітове І (AND)
        int andResult = a & b; // Результат: 2 (0010 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println("a & b = " + andResult);
        System.out.println(Integer.toBinaryString(andResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Побітове АБО (OR)
        int orResult = a | b;  // Результат: 14 (1110 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println("a | b = " + orResult);
        System.out.println(Integer.toBinaryString(orResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Побітове Виключне АБО (XOR)
        int xorResult = a ^ b; // Результат: 12 (1100 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println("a ^ b = " + xorResult);
        System.out.println(Integer.toBinaryString(xorResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Побітовий зсув вліво (Left Shift)
        int leftShiftResult = a << 1; // Результат: 20 (10100 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println("a << 1 = " + leftShiftResult);
        System.out.println(Integer.toBinaryString(leftShiftResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Побітовий зсув вправо (Right Shift)
        int rightShiftResult = a >> 1; // Результат: 5 (0101 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println("a >> 1 = " + rightShiftResult);
        System.out.println(Integer.toBinaryString(rightShiftResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Логічний побітовий зсув вправо з заповненням нулями (Zero-fill Right Shift)
        int zeroFillRightShiftResult = a >>> 1; // Результат: 5 (0101 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println("a >>> 1 = " + zeroFillRightShiftResult);
        System.out.println(Integer.toBinaryString(zeroFillRightShiftResult));

        System.out.println("-----------------------------------------------------------------------------------");

        // Побітове заперечення (NOT)
        int notResult = ~a; // Результат: -11 (11111111111111111111111111110101 в двійковій системі)
        System.out.println(Integer.toBinaryString(a));
        System.out.println("~a = " + notResult);
        System.out.println(Integer.toBinaryString(zeroFillRightShiftResult));
    }
}
