package org.example.lesson7;

import java.util.LinkedList;
import java.util.List;

// Клас BinaryTree для реалізації бінарного дерева
public class BinaryTree {
    private Node root;

    // Внутрішній клас Node для представлення вузла дерева
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // Головний метод main, який демонструє роботу бінарного дерева
    public static void main(String[] args) {
        // Створення об'єкту класу BinaryTree
        BinaryTree binaryTree = new BinaryTree();
        // Ініціалізація кореня дерева зі значенням 2
        binaryTree.root = new Node(2);
        // Додавання лівого нащадка кореня зі значенням 7
        binaryTree.root.left = new Node(7);
        // Додавання лівого нащадка лівого нащадка кореня зі значенням 2
        binaryTree.root.left.left = new Node(2);
        // Додавання правого нащадка кореня зі значенням 6
        binaryTree.root.right = new Node(6);
        // Додавання лівого нащадка правого нащадка кореня зі значенням 5
        binaryTree.root.right.left = new Node(5);
        // Додавання правого нащадка правого нащадка кореня зі значенням 11
        binaryTree.root.right.right = new Node(11);
        // Заміна правого нащадка кореня новим вузлом зі значенням 5
        binaryTree.root.right = new Node(5);
        // Заміна правого нащадка правого нащадка кореня новим вузлом зі значенням 9
        binaryTree.root.right.right = new Node(9);
        // Додавання лівого нащадка правого нащадка правого нащадка кореня зі значенням 4
        binaryTree.root.right.right.left = new Node(4);
        // Виведення результатів пошуку елементів
        System.out.println(binaryTree.search(binaryTree.root, 2)); // true
        System.out.println(binaryTree.search(binaryTree.root, 122)); // false
        System.out.println(binaryTree.search(binaryTree.root, 9)); // true
        System.out.println(binaryTree.search(binaryTree.root, 4)); // true
        System.out.println(binaryTree.search(binaryTree.root, 5)); // true
        System.out.println(binaryTree.search(binaryTree.root, 7)); // true
        // Виведення суми всіх елементів дерева
//        System.out.println(getSumElementsRecurse(binaryTree.root));

        LinkedList<Integer> list = new LinkedList<>();
        defineLongestWay(list, binaryTree.root);
        System.out.println(list);
    }

    // Метод search для пошуку елемента у бінарному дереві
    private boolean search(Node node, int key) {
        // Перевірка, чи вузол існує
        if (node != null) {
            // Перевірка, чи значення вузла дорівнює шуканому ключу
            if (node.value == key) {
                return true;
            }
            // Рекурсивний виклик методу search для лівого та правого піддерев
            boolean isFoundedElementInLeft = search(node.left, key);
            boolean isFoundedElementInRight = search(node.right, key);
            // Повернення результату пошуку у лівому або правому піддереві
            return isFoundedElementInLeft || isFoundedElementInRight;
        }
        // Повернення false, якщо вузол не існує
        return false;
    }

    // Статичний метод getSumElementsRecurse для обчислення суми всіх елементів дерева рекурсивно
    private static int getSumElementsRecurse(Node head) {
        int result = 0;
        // Перевірка, чи вузол існує
        if (head != null) {
            // Рекурсивний виклик методу для лівого піддерева, поточного елемента та правого піддерева
            result = getSumElementsRecurse(head.left) + head.value + getSumElementsRecurse(head.right);
        }
        // Повернення результату суми
        return result;
    }

    // Метод defineLongestWay призначений для знаходження найдовшого шляху у бінарному дереві та запису його значень у передану чергу.
// Вхідні параметри:
// - list: черга LinkedList<Integer>, у яку будуть записуватися значення найдовшого шляху
// - node: поточний вузол, з якого починається пошук найдовшого шляху
// Повертає: суму значень на найдовшому шляху, яка включає значення поточного вузла
    private static int defineLongestWay(LinkedList<Integer> list, Node node) {
        // Базовий випадок: якщо вузол не існує, повертаємо 0
        if (node == null) {
            return 0;
        }

        // Додаємо значення поточного вузла до черги
        list.addLast(node.value);

        // Ініціалізуємо чергу та суму для лівого піддерева
        LinkedList<Integer> leftWay = new LinkedList<>();
        int leftSum = defineLongestWay(leftWay, node.left);

        // Ініціалізуємо чергу та суму для правого піддерева
        LinkedList<Integer> rightWay = new LinkedList<>();
        int rightSum = defineLongestWay(rightWay, node.right);

        // Порівнюємо суми лівого та правого піддерев і визначаємо, який шлях є найдовшим
        if (leftSum > rightSum) {
            // Якщо лівий шлях найдовший, додаємо його значення до черги
            if (node.left != null) {
                list.addAll(leftWay);
            }
            // Повертаємо суму значень на найдовшому шляху, включаючи значення поточного вузла
            return leftSum + node.value;
        } else {
            // Якщо правий шлях найдовший, додаємо його значення до черги
            if (node.right != null) {
                list.addAll(rightWay);
            }
            // Повертаємо суму значень на найдовшому шляху, включаючи значення поточного вузла
            return rightSum + node.value;
        }
    }

}
