package org.example.lesson1;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>(List.of(1, 5, 100, 32, 5, -2));
        System.out.println("Before sorting: " + collection);

        bubbleSort(collection);

        System.out.println("After sorting: " + collection);
    }

    private static void bubbleSort(List<Integer> list) {
        // Починаємо з циклу, що проходиться по кожному елементу у списку.
        for (int i = 0; i < list.size(); i++) {
            // Другий цикл, що проходиться по кожному елементу до передостаннього (не включаючи останній).
            for (int j = 0; j < list.size() - 1; j++) {
                // Умова перевіряє, чи наступний елемент менший за поточний.
                if (list.get(j + 1) < list.get(j)) {
                    // Якщо умова if виконається, то виконуємо обмін елементів місцями.
                    // Тимчасова змінна temp використовується для збереження значення елемента,
                    // який буде переставлений.
                    int temp = list.get(j + 1);
                    // Заміна наступного елемента значенням поточного.
                    list.set(j + 1, list.get(j));
                    // Заміна поточного елемента значенням, що було збережено у змінній temp.
                    list.set(j, temp);
                }
            }
            System.out.println(list);
        }
    }


}
