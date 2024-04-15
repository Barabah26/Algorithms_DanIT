package org.example.lesson7;

import java.util.LinkedList;
import java.util.Queue;

// Клас BinarySearchTree для реалізації бінарного дерева пошуку
public class BinarySearchTree {
    // Поле root, що вказує на корінь дерева
    private Node root;

    // Внутрішній клас Node для представлення вузла дерева
    private static class Node {
        Integer value; // Значення вузла
        Node left; // Вузол-лівий нащадок
        Node right; // Вузол-правий нащадок

        // Конструктор класу Node
        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // Перевизначений метод toString() для зручного виводу значення вузла
        @Override
        public String toString() {
            return "{" + value + '}';
        }
    }

    // Метод для обхіду дерева у префіксному порядку
    public void preOrder() {
        preOrder(root);
    }

    // Приватний метод для обхіду дерева у префіксному порядку
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " "); // Виведення значення поточного вузла
        preOrder(node.left); // Рекурсивний виклик для лівого піддерева
        preOrder(node.right); // Рекурсивний виклик для правого піддерева
    }

    // Метод для виведення дерева за рівнями
    public void printByLevel(Node root, int maxLevel) {
        Queue<Node> prev = new LinkedList();
        Queue<Node> next = new LinkedList();
        Queue<Node> tmp;
        boolean isLevelNull = false;
        int gap = (int) Math.pow(2, maxLevel);
        prev.add(root);
        System.out.println();
        while (maxLevel > 0 && !isLevelNull && !prev.isEmpty()) {
            isLevelNull = true;
            System.out.print(String.format("%" + gap + "s", " "));
            while (!prev.isEmpty()) {
                Node node = prev.poll();
                System.out.print(node == null ? "--" : node);
                if (node != null && node.left != null) {
                    next.add(node.left);
                    isLevelNull = false;
                } else {
                    next.add(null);
                }
                System.out.print(String.format("%" + (gap * 2 - 2) + "s", " "));
                if (node != null && node.right != null) {
                    next.add(node.right);
                    isLevelNull = false;
                } else {
                    next.add(null);
                }
            }
            System.out.println();
            gap /= 2;
            maxLevel--;
            tmp = prev;
            prev = next;
            next = tmp;
        }
    }

    // Головний метод main, який демонструє роботу бінарного дерева пошуку
    public static void main(String[] args) {
        // Створення об'єкту класу BinarySearchTree
        BinarySearchTree tree = new BinarySearchTree();
        // Ініціалізація кореня дерева зі значенням 8
        tree.root = new Node(8, null, null);
        // Додавання лівого нащадка кореня зі значенням 3
        tree.root.left = new Node(3, null, null);
        // Додавання правого нащадка кореня зі значенням 10
        tree.root.right = new Node(10, null, null);
        // Додавання лівого нащадка лівого нащадка кореня зі значенням 1
        tree.root.left.left = new Node(1, null, null);
        // Додавання правого нащадка лівого нащадка кореня зі значенням 6
        tree.root.left.right = new Node(6, null, null);
        // Додавання правого нащадка правого нащадка кореня зі значенням 14
        tree.root.right.right = new Node(14, null, null);
        // Додавання лівого нащадка правого нащадка лівого нащадка кореня зі значенням 4
        tree.root.left.right.left = new Node(4, null, null);
        // Додавання правого нащадка правого нащадка лівого нащадка кореня зі значенням 7
        tree.root.left.right.right = new Node(7, null, null);
        // Додавання лівого нащадка правого нащадка правого нащадка кореня зі значенням 13
        tree.root.right.right.left = new Node(13, null, null);

        // Виклик методу search для пошуку значення 7 у дереві
        System.out.println(tree.search(tree.root, 7));

        // Додавання нових елементів у дерево
        tree.addElement(20, tree.root);
        tree.addElement(2, tree.root);
        tree.addElement(20, tree.root);

        // Виведення дерева за рівнями
        tree.printByLevel(tree.root, 6);
    }

    // Метод для пошуку значення у бінарному дереві пошуку
    public boolean search(Node node, int value) {
        // Базовий випадок: якщо вузол не існує, повертаємо false
        if(node == null){
            return false;
        }
        // Порівнюємо значення поточного вузла з шуканим значенням
        if (node.value == value){
            return true;
        } else {
            // Якщо значення поточного вузла менше шуканого, рекурсивно шукаємо у правому піддереві
            if (node.value < value){
                return search(node.right, value);
            } else { // Інакше рекурсивно шукаємо у лівому піддереві
                return search(node.left, value);
            }
        }
    }

    // Приватний метод для обхіду дерева в ширину
    private void breath() {
        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            System.out.print(node); // Виведення значення поточного вузла
        }
    }

    // Приватний метод для додавання нового елемента у дерево
    private void addElement(int value, Node node) {
        // Базовий випадок: якщо вузол не існує, повертаємо
        if(node == null) {
            return;
        }
        // Створюємо новий вузол з переданим значенням
        Node newNode = new Node(value, null, null);

        // Якщо передане значення менше значення поточного вузла, шукаємо місце для вставки у лівому піддереві
        if(value < node.value) {
            // Якщо ліве піддерево вільне, вставляємо новий вузол
            if(node.left == null) {
                node.left = newNode;
                return;
            }
            // Рекурсивно шукаємо місце для вставки у лівому піддереві
            addElement(value, node.left);
        } else { // Інакше шукаємо місце для вставки у правому піддереві
            // Якщо праве піддерево вільне, вставляємо новий вузол
            if(node.right == null) {
                node.right = newNode;
                return;
            }
            // Рекурсивно шукаємо місце для вставки у правому піддереві
            addElement(value, node.right);
        }
    }

    // Метод для видалення елемента з дерева за його значенням
    public Node deleteRec(Node node, int value) {
        // Написати реалізацію видалення елемента з дерева
        return node;
    }

    // Приватний метод для знаходження мінімального значення у піддереві, що починається з вказаного вузла
    private int minimumValue(Node node) {
        // Реалізацію цього методу потрібно додати
        throw new UnsupportedOperationException();
    }
}
