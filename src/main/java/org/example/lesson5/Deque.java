package org.example.lesson5;

import java.util.Arrays;

// Клас, що реалізує структуру даних Deque (Double-ended queue)
public class Deque<T> {
    private static final int DEFAULT_CAPACITY = 10; // Стандартний розмір масиву
    private Object[] elements; // Масив елементів
    private int size; // Поточний розмір черги
    private int front; // Індекс першого елемента у черзі
    private int rear; // Індекс наступного вільного місця для додавання елемента у черзі

    // Конструктор без параметрів, що ініціалізує масив елементів зі стандартним розміром
    public Deque() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Конструктор, що ініціалізує масив елементів з заданим розміром
    public Deque(int capacity) {
        elements = new Object[capacity];
    }

    // Метод для додавання елемента у початок черги
    public void addFirst(T item) {
        if (size == elements.length)
            throw new IllegalStateException("Deque is full"); // Викид винятку, якщо черга повна
        front = (front - 1 + elements.length) % elements.length; // Переміщення front на попереднє вільне місце (циклічна реалізація)
        elements[front] = item; // Додавання елемента на нове місце
        size++; // Збільшення розміру черги
    }

    // Метод для додавання елемента у кінець черги
    public void addLast(T item) {
        if (size == elements.length)
            resize(); // Перевірка та зміна розміру масиву, якщо черга повна
        elements[rear] = item; // Додавання елемента у вільне місце в кінці черги
        rear = (rear + 1) % elements.length; // Переміщення rear на наступне вільне місце (циклічна реалізація)
        size++; // Збільшення розміру черги
    }

    // Метод для зміни розміру масиву, коли він стає повним
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length * 2; // Подвоєння розміру масиву
        Object[] newElements = new Object[newCapacity]; // Створення нового масиву з подвоєним розміром
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length]; // Копіювання елементів у новий масив
        }
        elements = newElements; // Заміна посилання на старий масив новим
        front = 0; // Оновлення значення front
        rear = size; // Оновлення значення rear
    }


    // Метод для видалення та повернення елемента з початку черги
    @SuppressWarnings("unchecked")
    public T removeFirst() {
        if (isEmpty())
            throw new IllegalStateException("Deque is empty"); // Викид винятку, якщо черга порожня
        T item = (T) elements[front]; // Зберігання елемента, який буде видалено
        elements[front] = null; // Позначення місця елемента у масиві як null (для GC)
        front = (front + 1) % elements.length; // Переміщення front на наступний елемент (циклічна реалізація)
        size--; // Зменшення розміру черги
        return item; // Повернення видаленого елемента
    }

    // Метод для видалення та повернення елемента з кінця черги
    @SuppressWarnings("unchecked")
    public T removeLast() {
        if (isEmpty())
            throw new IllegalStateException("Deque is empty"); // Викид винятку, якщо черга порожня
        rear = (rear - 1 + elements.length) % elements.length; // Переміщення rear на попереднє вільне місце (циклічна реалізація)
        T item = (T) elements[rear]; // Зберігання елемента, який буде видалено
        elements[rear] = null; // Позначення місця елемента у масиві як null (для GC)
        size--; // Зменшення розміру черги
        return item; // Повернення видаленого елемента
    }

    // Метод для перевірки, чи черга порожня
    public boolean isEmpty() {
        return size == 0; // Порожня черга, якщо size = 0
    }

    // Метод для отримання розміру черги
    public int size() {
        return size; // Повернення поточного розміру черги
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(23);
        deque.addFirst(12);
        deque.addFirst(11);
        deque.addLast(34);

        System.out.println(deque);
    }
}
