package org.example.lesson3;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 100, 32, 5, -2};
        System.out.println("Before sorting: " + Arrays.toString(array));

        sort(array, 0, array.length - 1);

        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static void sort(int[] array, int begin, int end) {
        // Перевіряємо, чи потрібно сортувати дану частину масиву.
        // Якщо початковий індекс більше або дорівнює кінцевому,
        // то масив з одного елемента або пустий, тому сортування не потрібне.
        if (begin >= end) {
            return;
        }

        // Знаходимо позицію опорного елементу в масиві і відокремлюємо
        // масив на дві частини, в яких елементи менші за опорний та більші.
        int pivot = partition(array, begin, end);

        // Рекурсивно сортуємо ліву частину масиву (з елементами меншими за опорний).
        sort(array, begin, pivot - 1);

        // Рекурсивно сортуємо праву частину масиву (з елементами більшими за опорний).
        sort(array, pivot + 1, end);
    }


    private static int partition(int[] array, int begin, int end) {
        // Вибираємо крайній правий елемент масиву як опорний елемент для порівняння.
        int pivot = array[end];

        // Індекс, що вказує на кінець частини з елементами меншими за опорний.
        int i = begin - 1;

        // Проходимося по масиву з початкового до кінцевого індексу (не включаючи його).
        for (int j = begin; j < end; j++) {
            // Якщо поточний елемент менший або рівний опорному, то потрібно зробити обмін.
            if (array[j] <= pivot) {
                // Збільшуємо індекс, що вказує на кінець частини з елементами меншими за опорний.
                i++;
                // Обмінюємо поточний елемент з елементом, що перебуває на позиції, вказаній `i`.
                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        // Після проходження всіх елементів масиву, ми обміняли всі елементи менші за опорний
        // на початку масиву. Тепер потрібно поставити опорний елемент на його правильне місце.
        // Обмінюємо опорний елемент з першим елементом більшим за нього, який знаходиться на позиції `(i + 1)`.
        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        // Повертаємо індекс опорного елемента, що знаходиться на своєму правильному місці.
        return i + 1;
    }



}
