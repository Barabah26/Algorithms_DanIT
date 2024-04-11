package org.example.lesson6;

import java.util.Arrays;

// Клас BinaryInsert для впорядкування масиву методом вставки з використанням бінарного пошуку
public class BinaryInsert {

    // Головний метод main, який демонструє сортування методом вставки з використанням бінарного пошуку
    public static void main(String[] args) {
        // Задання вхідного масиву для сортування
        int[] arr = {1, 25, 4, 3, 6, 5, 9, 8, 7};
        // Виклик методу сортування sort
        sort(arr);
        // Виведення відсортованого масиву на екран
        System.out.println(Arrays.toString(arr));
    }

    // Метод сортування sort, що впорядковує масив методом вставки з використанням бінарного пошуку
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i]; // Зберігаємо поточний елемент масиву

            // Визначення відстані до позиції для вставки методом бінарного пошуку
            int distPosition = calcDistPosition(array, i, tmp);
            int length = i - distPosition;

            // Якщо позиція для вставки не є поточною позицією елемента, вставляємо його
            if (distPosition != i){
                // Зсув елементів масиву для вставки нового елемента
                System.arraycopy(array, distPosition, array, distPosition + 1, length);
                // Вставка нового елемента на відповідну позицію
                array[distPosition] = tmp;
            }
        }
    }

    // Метод calcDistPosition для обчислення позиції для вставки методом бінарного пошуку
    private static int calcDistPosition(int[] array, int from, int key) {
        int low = 0;
        int high = from;
        int mid;

        // Бінарний пошук позиції для вставки нового елемента
        while (low <= high){
            mid = low + ((high - low) / 2);

            // Якщо значення у середині дорівнює шуканому ключу, повертаємо його позицію
            if (array[mid] == key){
                return mid;
            }

            // Якщо значення у середині менше ключа, зміщуємо ліву границю пошуку
            if (array[mid] < key){
                low = mid + 1;
            } else { // В іншому випадку зміщуємо праву границю пошуку
                high = mid - 1;
            }
        }

        // Повертаємо позицію, на яку слід вставити новий елемент
        return high + 1;
    }
}
