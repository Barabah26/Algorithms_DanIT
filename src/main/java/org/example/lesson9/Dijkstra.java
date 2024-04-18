package org.example.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    // Вкладений клас, що представляє вершину графа
    public static class Vertex implements Comparable<Vertex> {
        private String name; // Назва вершини
        private List<Edge> edges = new ArrayList<>(); // Список ребер, які виходять з цієї вершини
        private double minDistance = Double.POSITIVE_INFINITY; // Мінімальна відстань від початкової вершини до цієї вершини
        private Vertex previous; // Попередня вершина в найкоротшому шляху

        // Конструктор вершини
        public Vertex(String name) {
            this.name = name;
        }

        // Реалізація методу порівняння для сортування вершин за їхніми мінімальними відстанями
        public int compareTo(Vertex other) {
            return Double.compare(minDistance, other.minDistance);
        }

        // Перевизначений метод toString() для зручного виведення вершини
        @Override
        public String toString() {
            return "{" + name + '}';
        }
    }

    // Вкладений запис, який представляє ребро графа
    record Edge(Vertex target, double weight) {}

    // Метод main, який демонструє використання алгоритму Дейкстри
    public static void main(String[] args) {
        // Створення вершин графа
        Vertex s = new Vertex("s");
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");

        // Додавання ребер між вершинами
        s.edges.addAll(Arrays.asList(
                new Edge(a, 1),
                new Edge(b, 5)));
        a.edges.addAll(Arrays.asList(
                new Edge(c, 2),
                new Edge(b, 2),
                new Edge(d, 1)));
        b.edges.addAll(Arrays.asList(
                new Edge(d, 2)));
        c.edges.addAll(Arrays.asList(
                new Edge(e, 1),
                new Edge(d, 3)));
        d.edges.addAll(Arrays.asList(
                new Edge(e, 2)));

        // Обчислення найкоротших шляхів від вершини s
        computePaths(s);
        // Отримання найкоротшого шляху до вершини e
        List<Vertex> path = getShortestPathTo(e);
        System.out.println("Path: " + path);
    }

    // Метод для обчислення найкоротших шляхів в графі від заданої вершини
    public static void computePaths(Vertex source) {
        source.minDistance = 0; // Відстань від початкової вершини до неї ж самої дорівнює 0
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>(); // Пріоритетна черга для зберігання вершин
        vertexQueue.offer(source); // Додаємо початкову вершину в чергу

        // Поки черга не порожня
        while (!vertexQueue.isEmpty()) {
            Vertex current = vertexQueue.poll(); // Беремо вершину з найменшою відстанню
            for (Edge adjEdge : current.edges) { // Для кожного сусіднього ребра
                Vertex neighbour = adjEdge.target; // Отримуємо сусідню вершину
                double edgeWeight = adjEdge.weight; // Отримуємо вагу ребра
                double distanceThroughCurrent = current.minDistance + edgeWeight; // Відстань через поточну вершину

                // Якщо відстань через поточну вершину до сусідньої вершини менша за поточну відстань до сусідньої вершини
                if (distanceThroughCurrent < neighbour.minDistance){
                    neighbour.minDistance = distanceThroughCurrent; // Оновлюємо мінімальну відстань до сусідньої вершини
                    neighbour.previous = current; // Встановлюємо поточну вершину як попередню для сусідньої вершини
                    vertexQueue.offer(neighbour); // Додаємо сусідню вершину в чергу
                }
            }
        }
    }

    // Метод для отримання найкоротшого шляху до заданої вершини
    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>(); // Список для зберігання вершин найкоротшого шляху
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex); // Додаємо кожну вершину шляху до списку
        }
        Collections.reverse(path); // Реверсуємо список, щоб він був у порядку від початкової вершини до цільової
        return path; // Повертаємо список найкоротшого шляху
    }
}
