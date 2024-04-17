package org.example.lesson1;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        // Задання масиву для сортування
        int[] vector = { 20, 12, 10, 15, 2 };
        // Виклик методу сортування
        int[] sortedVector = new CountingSort().sort(vector, 20);
        // Виведення відсортованого масиву
        System.out.println(Arrays.toString(sortedVector));
    }

    // Метод сортування Counting Sort
    public static int[] sort(int[] theArray, int maxValue) {
        // Створення масиву для підрахунку кількості елементів
        int[] counts = new int[maxValue + 1];

        // Підрахунок кількості кожного елемента в масиві
        for (int item : theArray) {
            counts[item] += 1;
        }

        // Кумулятивна сума кількостей елементів до кожного індексу
        int numItemsBefore = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = numItemsBefore;
            numItemsBefore += count;
        }

        // Створення відсортованого масиву
        int[] sortedArray = new int[theArray.length];

        // Розміщення елементів у відсортований масив
        for (int item : theArray) {
            sortedArray[counts[item]] = item;
            counts[item] += 1;
        }

        // Повернення відсортованого масиву
        return sortedArray;
    }
}
