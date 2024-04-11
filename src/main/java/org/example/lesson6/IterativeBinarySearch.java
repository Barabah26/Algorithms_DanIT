package org.example.lesson6;

// Клас IterativeBinarySearch для реалізації ітеративного бінарного пошуку
public class IterativeBinarySearch {

    // Головний метод main, який демонструє роботу бінарного пошуку
    public static void main(String[] args) {
        // Задання вхідного масиву для пошуку
        int[] arr = {1, 2, 365, 3333, 90000, 1234567};
        // Виклик методу binarySearch для пошуку значення 1 в масиві arr
        System.out.println(binarySearch(arr, 1));
    }

    // Метод binarySearch виконує ітеративний бінарний пошук
    // в масиві arr для значення value
    public static int binarySearch(int[] arr, int value){
        // Ініціалізація змінних для індексів початку та кінця масиву
        int start = 0;
        int end = arr.length - 1;
        int mid; // Змінна для зберігання середнього індексу

        // Повторюємо пошук, поки початковий індекс не перевищить кінцевий
        while (start <= end){
            // Знаходимо середину діапазону
            mid = (start + end) / 2;

            // Якщо значення у середині дорівнює шуканому, повертаємо його індекс
            if (arr[mid] == value){
                return mid;
            }

            // Якщо значення у середині менше шуканого,
            // зміщуємо діапазон вправо (вище за середину)
            if (arr[mid] < value){
                start = mid + 1;
            } else { // В іншому випадку зміщуємо діапазон вліво (нижче за середину)
                end = mid - 1;
            }
        }
        // Якщо значення не знайдено в масиві, повертаємо -1
        return -1;
    }
}
