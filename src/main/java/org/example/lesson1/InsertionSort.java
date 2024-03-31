package org.example.lesson1;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>(List.of(1, 5, 200, 90, 5, -2));
        System.out.println("Before sorting: " + collection);

        insertionSort(collection);

        System.out.println("After sorting: " + collection);
    }

    private static void insertionSort(List<Integer> list){
        // Починаємо з індексу 1, оскільки перший елемент вважається відсортованим.
        for (int i = 1; i < list.size(); i++) {
            // Внутрішній цикл для перебору відсортованої частини списку.
            for (int j = i; j > 0; j--) {
                // Порівнюємо поточний елемент з попереднім і обмінюємо їх, якщо потрібно.
                if (list.get(j) < list.get(j - 1)){
                    // Якщо умова if виконується, то виконуємо обмін елементів місцями.
                    // Ми порівнюємо поточний елемент з попереднім (елементом з меншим індексом).
                    // Якщо поточний елемент менший за попередній, то ми їх обмінюємо місцями.
                    int temp = list.get(j); // Тимчасово зберігаємо значення поточного елемента.
                    list.set(j, list.get(j - 1)); // Замінюємо поточний елемент значенням попереднього елемента.
                    list.set(j - 1, temp); // Замінюємо попередній елемент значенням, яке було у тимчасовій змінній.

                }
            }

            System.out.println(list);
        }
    }

}
