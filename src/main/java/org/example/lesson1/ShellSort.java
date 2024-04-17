package org.example.lesson1;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        // Задання масиву для сортування
        int[] vector = {35, 33, 42, 10, 14, 19, 27, 44};
        // Створення екземпляру класу ShellSort і виклик методу сортування
        new ShellSort().sort(vector);
        // Виведення відсортованого масиву
        System.out.println(Arrays.toString(vector));
    }

    // Метод сортування за допомогою алгоритму Shell Sort
    void sort(int[] array) {
        // Цикл для визначення кроку сортування
        for (int interval = array.length / 2; interval > 0; interval /= 2) {
            // Цикл для проходження по масиву з використанням визначеного кроку
            for (int i = interval; i < array.length; i += 1) {
                // Збереження поточного елемента масиву в тимчасову змінну
                int temp = array[i];
                int j;
                // Цикл для вставки елемента на відповідне місце в підмасиві
                for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
                    // Переміщення елементів вправо для забезпечення правильного місця для вставки
                    array[j] = array[j - interval];
                }
                // Вставка елемента на відповідне місце
                array[j] = temp;
            }
        }
    }

}

