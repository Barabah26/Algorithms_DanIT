package org.example.lesson3;

import java.math.BigInteger;

public class BigIntegerFibonacci {
    public static BigInteger[] calculated = new BigInteger[100];
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(fib(BigInteger.valueOf(45)));
        System.out.println(System.currentTimeMillis() - time);
    }

    private static BigInteger fib(BigInteger number) {
        if (calculated[number.intValue()] != null){
            return calculated[number.intValue()];
        }
        if (number.equals(BigInteger.ZERO)){
            return BigInteger.ZERO;
        }

        if (number.compareTo(BigInteger.TWO) < 1){
            return BigInteger.ONE;
        }

//        return fib(number.subtract(BigInteger.ONE)).add(fib(number.subtract(BigInteger.TWO)));

        BigInteger fib1 = fib(number.subtract(BigInteger.ONE));
        calculated[number.subtract(BigInteger.ONE).intValue()] = fib1;
        BigInteger fib2 = fib(number.subtract(BigInteger.TWO));
        calculated[number.subtract(BigInteger.TWO).intValue()] = fib2;
        BigInteger sum = fib1.add(fib2);
        return sum;

    }


}
