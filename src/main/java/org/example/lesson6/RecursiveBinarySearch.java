package org.example.lesson6;

// Клас RecursiveBinarySearch для реалізації рекурсивного бінарного пошуку
public class RecursiveBinarySearch {

    // Головний метод main, який демонструє роботу рекурсивного бінарного пошуку
    public static void main(String[] args) {
        // Задання вхідного масиву для пошуку
        int[] arr = {1, 2, 365, 3333, 90000, 1234567};
        // Виклик рекурсивного методу binarySearch для пошуку значення 2 в масиві arr
        System.out.println(binarySearch(arr, 2, 0, arr.length - 1));
    }

    // Рекурсивний метод binarySearch для виконання бінарного пошуку
    // в масиві arr для значення value у діапазоні від low до high
    private static int binarySearch(int[] arr, int value, int low, int high) {
        // Обчислення середнього індексу
        int mid = low + ((high - low) / 2);

        // Якщо значення у середині дорівнює шуканому, повертаємо його індекс
        if (arr[mid] == value){
            return mid;
        }

        // Якщо діапазон закінчився і значення не знайдено, повертаємо -1
        if(high <= low){
            return -1;
        }

        // Якщо значення у середині менше шуканого,
        // викликаємо рекурсивно binarySearch для правої половини масиву
        if (arr[mid] < value){
            return binarySearch(arr, value, mid + 1, high);
        } else { // В іншому випадку викликаємо рекурсивно binarySearch для лівої половини масиву
            return binarySearch(arr, value, low, mid - 1);
        }
    }
}
