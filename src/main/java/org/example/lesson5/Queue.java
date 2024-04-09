package org.example.lesson5;

import java.util.Arrays;

// Клас, що реалізує структуру даних Queue
public class Queue<T> {
    private static final int DEFAULT_CAPACITY = 10; // Стандартний розмір масиву
    private Object[] elements; // Масив елементів
    private int size; // Поточний розмір черги
    private int front; // Індекс першого елемента у черзі
    private int rear; // Індекс наступного вільного місця для додавання елемента у черзі

    // Конструктор без параметрів, що ініціалізує масив елементів зі стандартним розміром
    public Queue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Конструктор, що ініціалізує масив елементів з заданим розміром
    public Queue(int capacity) {
        elements = new Object[capacity];
    }

    // Метод для додавання елемента у кінець черги
    public void enqueue(T item) {
        if (size == elements.length)
            throw new IllegalStateException("Queue is full"); // Викид винятку, якщо черга повна
        elements[rear] = item; // Додавання елемента у вільне місце в кінці черги
        rear = (rear + 1) % elements.length; // Переміщення rear на наступне вільне місце (циклічна реалізація)
        size++; // Збільшення розміру черги
    }

    // Метод для видалення та повернення елемента з початку черги
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty"); // Викид винятку, якщо черга порожня
        T item = (T) elements[front]; // Зберігання елемента, який буде видалено
        elements[front] = null; // Позначення місця елемента у масиві як null (для GC)
        front = (front + 1) % elements.length; // Переміщення front на наступний елемент (циклічна реалізація)
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
        Queue<Integer> queue = new Queue<>(8);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(15);
        queue.enqueue(22);
        queue.enqueue(52);
        queue.enqueue(82);
        queue.enqueue(92);
        queue.enqueue(1);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        System.out.println(queue.isEmpty());

        System.out.println(queue.size());
    }
}

