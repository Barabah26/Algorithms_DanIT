package org.example.lesson1;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>(List.of(1, 5, 200, 90, 5, -2));
        System.out.println("Before sorting: " + collection);

        selectionSort(collection);

        System.out.println("After sorting: " + collection);
    }

    private static void selectionSort(List<Integer> list){
        // Зовнішній цикл проходить по всім елементам списку, окрім останнього.
        for (int i = 0; i < list.size(); i++) {
            // Припускаємо, що поточний елемент має найменше значення.
            int minIndex = i;
            // Внутрішній цикл проходить по залишку списку, що залишився після поточного індексу.
            for (int j = i + 1; j < list.size(); j++) {
                // Порівнюємо значення елементів, щоб знайти найменший.
                if (list.get(j) < list.get(minIndex)){
                    // Якщо знайдено елемент, що менший за поточний найменший, оновлюємо індекс найменшого.
                    minIndex = j;
                }
            }
            // Після завершення внутрішнього циклу, коли знайдено найменший елемент
            // на позиції minIndex, ми обмінюємо його з поточним елементом, що розглядається (на позиції i).
            int temp = list.get(minIndex); // Зберігаємо значення найменшого елемента в змінну temp.
            list.set(minIndex, list.get(i)); // Замінюємо значення найменшого елемента значенням поточного.
            list.set(i, temp); // Замінюємо значення поточного елемента значенням, яке було у змінній temp.


            System.out.println(list);
        }
    }

}
