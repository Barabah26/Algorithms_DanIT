package org.example.lesson4;

// Визначення класу LinkList
public class LinkList {
    // Об'явлення приватних змінних екземпляра
    private Node head; // Посилання на перший вузол у списку
    private int size; // Кількість вузлів у списку

    // Метод для отримання розміру списку
    public int size() {
        return size;
    }

    // Визначення внутрішнього класу Node
    private static class Node {
        private int value; // Значення, що зберігається у вузлі
        private Node next; // Посилання на наступний вузол у списку

        // Конструктор для ініціалізації вузла значенням і посиланням на наступний вузол
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        // Метод для отримання значення, що зберігається у вузлі
        public int getValue() {
            return value;
        }

        // Метод-сеттер для оновлення значення, що зберігається у вузлі
        public void setValue(int value) {
            this.value = value;
        }

        // Метод для отримання посилання на наступний вузол
        public Node getNext() {
            return next;
        }

        // Метод-сеттер для оновлення посилання на наступний вузол
        public void setNext(Node next) {
            this.next = next;
        }

        // Перевизначення методу toString для представлення вузла як рядка
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    // Головний метод для тестування функціоналу класу LinkList
    public static void main(String[] args) {

        // Створення екземпляру LinkList
        LinkList list = new LinkList();
        // Додавання елементів до списку
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);
        list.add(2, 10);
        list.add(0, 11);
        list.add(7, 12);
        // Видалення елемента зі списку
        list.remove(7);

        // Виведення списку
        System.out.println(list);
        // Отримання та виведення значення за індексом 5
        System.out.println(list.get(5));
    }

    // Метод для додавання елемента в початок списку
    public void addFirst(int value) {
        // Створення нового вузла з переданим значенням і посиланням на поточний head
        Node newNode = new Node(value, head);
        // Оновлення посилання head на новий вузол
        head = newNode;
        // Збільшення розміру списку
        size++;
    }

    // Метод для додавання елемента в кінець списку
    public void addLast(int value) {
        // Створення нового вузла з переданим значенням і посиланням на null (оскільки він буде останнім в списку)
        Node newNode = new Node(value, null);
        // Якщо список порожній, то новий вузол стає першим і останнім елементом
        if (head == null) {
            head = newNode;
        } else {
            // Якщо список не порожній, потрібно пройтися до останнього елементу
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Оновлення посилання останнього елементу на новий вузол
            current.next = newNode;
        }
        // Збільшення розміру списку
        size++;
    }

    // Метод для додавання елемента за певним індексом у списку
    public void add(int index, int value) {
        // Перевірка, чи індекс в межах допустимого діапазону
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is absent: " + index);
        }
        // Якщо індекс дорівнює 0, елемент додається у початок списку за допомогою методу addFirst
        if (index == 0) {
            addFirst(value);
            return;
        }
        // Якщо індекс не нульовий, потрібно пройтися до елементу, який знаходиться перед індексом, щоб оновити посилання
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        // Оновлення посилання поточного елементу на новий вузол, а новий вузол посилається на наступний елемент
        current.next = new Node(value, current.next);
        // Збільшення розміру списку
        size++;
    }

    // Перевизначений метод toString для виведення списку як рядка
    @Override
    public String toString() {
        Node temp = head;
        StringBuilder res = new StringBuilder();

        // Проходження через всі елементи списку і додавання їх значень до рядка з роздільниками "->"
        while (temp != null) {
            res = res.append(temp.value);
            if (temp.next != null) {
                res = res.append("->");
            }
            temp = temp.next;
        }

        return res.toString();
    }

    // Метод для видалення елемента за певним індексом у списку
    public void remove(int index) {
        // Перевірка, чи індекс в межах допустимого діапазону
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is absent: " + index);
        }
        // Якщо індекс дорівнює 0, елемент видаляється з початку списку
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        // Якщо індекс не нульовий, потрібно пройтися до елементу, який знаходиться перед індексом, щоб оновити посилання
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        // Оновлення посилання поточного елементу на наступний елемент після елементу, який має бути видалений
        current.next = current.next.next;
        // Зменшення розміру списку
        size--;
    }

    // Метод для отримання значення за певним індексом у списку
    public int get(int index) {
        // Перевірка, чи індекс в межах допустимого діапазону
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index is absent: " + index);
        }
        int count = 0;
        Node current = head;
        // Пройдіть через список, поки не досягнете вказаного індексу
        for (; index != count; current = current.next, count++) {}

        return current.value;
    }

}
