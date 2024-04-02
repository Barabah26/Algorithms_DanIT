package org.example.lesson1;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>(List.of(1, 5, 100, 32, 5, -2));
        System.out.println("Before sorting: " + collection);

        sort(collection);

        System.out.println("After sorting: " + collection);
    }

    private static void sort(List<Integer> list){ // Початок методу sort, який виконує сортування
        if (list.isEmpty() || list.size() == 0) // Перевірка, чи список порожній
            return; // Повернення, якщо список порожній
        quickSort(list, 0, list.size() - 1); // Виклик рекурсивного методу сортування
    } // Завершення методу sort

    private static void quickSort(List<Integer> list, int start, int end) { // Початок методу quickSort, який виконує швидке сортування
        int i = start; // Ініціалізація змінної i початковим індексом
        int j = end; // Ініціалізація змінної j кінцевим індексом

        int pivot = list.get((start + (end - start)) / 2); // Вибір опорного елемента (pivot)

        while (i <= j) { // Початок циклу розподілення
            while (list.get(i) < pivot) { // Пошук елементів, які менші за опорний
                i++; // Збільшення індексу i
            }
            while (list.get(j) > pivot) { // Пошук елементів, які більші за опорний
                j--; // Зменшення індексу j
            }
            if (i <= j) { // Перевірка, чи елементи потрібно обміняти
                swap(list, i, j); // Обмін елементів
                i++; // Збільшення індексу i
                j--; // Зменшення індексу j
            }
        } // Кінець циклу розподілення

        if (start < j) // Перевірка, чи існують елементи для сортування зліва від опорного
            quickSort(list, start, j); // Рекурсивний виклик quickSort для сортування лівого підсписку
        if (i < end) // Перевірка, чи існують елементи для сортування справа від опорного
            quickSort(list, i, end); // Рекурсивний виклик quickSort для сортування правого підсписку
    }

    private static void swap(List<Integer> list, int i, int j){ // Початок методу swap, який обмінює місцями два елементи списку
        int temp = list.get(i); // Збереження значення елемента list[i]
        list.set(i, list.get(j)); // Заміна елемента list[i] елементом list[j]
        list.set(j, temp); // Заміна елемента list[j] значенням temp
    }


}
