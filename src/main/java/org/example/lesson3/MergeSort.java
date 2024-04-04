package org.example.lesson3;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 100, 32, 5, -2};
        System.out.println("Before sorting: " + Arrays.toString(array));

        sort(array, 0, array.length - 1);

        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static void sort(int[] array, int begin, int end) {
        // Перевіряємо, чи потрібно сортувати дану частину масиву.
        // Якщо початковий індекс більший або дорівнює кінцевому індексу,
        // це означає, що масив містить лише один елемент або взагалі порожній,
        // тому немає потреби в сортуванні.
        if (begin >= end) {
            return;
        }

        // Знаходимо середній елемент масиву, щоб розділити його на дві частини.
        int middle = (end + begin) / 2;

        // Рекурсивно сортуємо ліву частину масиву.
        sort(array, begin, middle);

        // Рекурсивно сортуємо праву частину масиву.
        sort(array, middle + 1, end);

        // Об'єднуємо відсортовані частини масиву.
        merge(array, begin, middle, end);
    }

    private static void merge(int[] array, int from, int mid, int to) {
        // Створюємо тимчасовий масив для зберігання об'єднаних значень.
        int[] temp = new int[to - from + 1];

        // Ініціалізуємо індекси для першої (from..mid) та другої (mid+1..to) частин масиву.
        int i = from;
        int j = mid + 1;

        // Індекс для тимчасового масиву.
        int k = 0;

        // Об'єднуємо відсортовані частини масиву, порівнюючи значення з кожної частини.
        while (i <= mid && j <= to) {
            // Перевіряємо, чи індекси не вийшли за межі своїх частин масиву.
            // Якщо ні, продовжуємо порівнювати та записувати значення в тимчасовий масив.

            if (array[i] <= array[j]) {
                // Якщо значення елемента з лівої частини менше або рівне значенню елемента
                // з правої частини, то записуємо елемент з лівої частини в тимчасовий масив.
                temp[k++] = array[i++];
            } else {
                // Якщо значення елемента з правої частини менше значення елемента з лівої,
                // то записуємо елемент з правої частини в тимчасовий масив.
                temp[k++] = array[j++];
            }
        }


        // Додаємо залишкові елементи з першої частини масиву, якщо вони є.
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // Додаємо залишкові елементи з другої частини масиву, якщо вони є.
        while (j <= to) {
            temp[k++] = array[j++];
        }

        // Копіюємо відсортований тимчасовий масив назад у вихідний масив.
        System.arraycopy(temp, 0, array, from, to - from + 1);
    }
}
