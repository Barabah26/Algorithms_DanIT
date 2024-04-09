package org.example.lesson5;

import org.example.lesson4.LinkList;

// Клас, що реалізує гру "Ханойські вежі"
public class Hanoi {
    // Внутрішній клас, що представляє стек для використання в грі
    private static class HanoiStack {
        private LinkList list = new LinkList(); // Використання реалізації стеку на основі списку

        // Метод для додавання елемента в стек
        public int push(int item) {
            // Перевірка, чи новий елемент менший за верхній елемент стеку
            if (list.size() > 0 && item >= peek()) {
                throw new RuntimeException("Item %d should be less, than value of top item (%d)".formatted(item, peek()));
            }
            list.addFirst(item); // Додавання елемента на вершину стеку
            return item;
        }

        // Метод для видалення та повернення верхнього елемента стеку
        public int pop() {
            int head = list.get(0); // Отримання значення верхнього елемента
            list.remove(0); // Видалення верхнього елемента
            return head; // Повернення значення верхнього елемента
        }

        // Метод для отримання значення верхнього елемента стеку без його видалення
        public int peek() {
            return list.get(0); // Повернення значення верхнього елемента
        }

        // Метод для отримання розміру стеку
        public int size() {
            return list.size(); // Повернення кількості елементів у стеку
        }

        // Перевизначений метод toString для виведення стеку як рядка
        @Override
        public String toString() {
            return list.toString(); // Повернення рядкового представлення списку, яке є реалізацією стеку
        }
    }

    // Головний метод, який викликається при запуску програми
    public static void main(String args[]) {
        HanoiStack rodA = new HanoiStack(); // Створення стеку для першої вежі
        rodA.push(5); // Додавання дисків до першої вежі
        rodA.push(4);
        rodA.push(3);
        rodA.push(2);
        rodA.push(1);
        HanoiStack rodB = new HanoiStack(); // Створення стеку для другої вежі
        HanoiStack rodC = new HanoiStack(); // Створення стеку для третьої вежі
        System.out.println("peek(): " + rodA.peek()); // Виведення значення верхнього елемента першої вежі
        towerOfHanoi(rodA.size(), rodA, rodB, rodC); // Виклик рекурсивної функції для розв'язання гри
        System.out.println(rodB); // Виведення вмісту другої вежі після виконання гри
    }

    // Рекурсивна функція для вирішення гри "Ханойські вежі"
    static void towerOfHanoi(int numberOfDiscsForMove, HanoiStack fromRod, HanoiStack toRod, HanoiStack auxRod) {
        // Умова виходу з рекурсії - переміщення одного диска
        if (numberOfDiscsForMove == 1) {
            toRod.push(fromRod.pop()); // Переміщення диска з початкової вежі на цільову
            return;
        }
        // Рекурсивний виклик для переміщення (numberOfDiscsForMove - 1) дисків з початкової вежі на допоміжну
        towerOfHanoi(numberOfDiscsForMove - 1, fromRod, auxRod, toRod);
        // Переміщення останнього диска з початкової вежі на цільову
        toRod.push(fromRod.pop());
        // Рекурсивний виклик для переміщення (numberOfDiscsForMove - 1) дисків з допоміжної вежі на цільову
        towerOfHanoi(numberOfDiscsForMove - 1, auxRod, toRod, fromRod);
    }
}
