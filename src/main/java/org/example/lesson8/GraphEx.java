// Пакет та імпорти
package org.example.lesson8;

import java.util.*;

// Клас, що представляє граф та виконує операції над ним
public class GraphEx {

    // Внутрішній клас, що представляє вершину графа
    public static class Vertex {
        public int value; // Значення вершини
        public Set<Vertex> neighbours; // Множина сусідніх вершин
        private boolean visited; // Прапорець, що вказує на те, чи була відвідана вершина
        private Vertex prev; // Попередня вершина при пошуку шляху

        // Конструктор вершини з заданим значенням
        public Vertex(int value) {
            this.value = value;
            this.neighbours = new HashSet<>(); // Ініціалізуємо множину сусідів
        }

        // Перевизначений метод toString для зручного виведення вершини
        @Override
        public String toString() {
            return "{" + value + '}';
        }
    }

    // Метод main для демонстрації роботи з графом
    public static void main(String[] args) {
        // Створюємо вершини графа
        Vertex vertexZero = new Vertex(0);
        Vertex vertexOne = new Vertex(1);
        Vertex vertexTwo = new Vertex(2);
        Vertex vertexThree = new Vertex(3);
        Vertex vertexFour = new Vertex(4);
        Vertex vertexFive = new Vertex(5);

        // Встановлюємо зв'язки між вершинами
        vertexZero.neighbours = Set.of(vertexOne, vertexThree, vertexFour);
        vertexOne.neighbours = Set.of(vertexZero, vertexTwo);
        vertexTwo.neighbours = Set.of(vertexOne);
        vertexThree.neighbours = Set.of(vertexZero, vertexFive);
        vertexFour.neighbours = Set.of(vertexZero, vertexFive);
        vertexFive.neighbours = Set.of(vertexThree, vertexFour);

        // Виклик методу обходу графа в глибину (DFS) та виведення результату
        printDFS(vertexTwo, new HashSet<>());
        System.out.println();

        // Ініціалізуємо список для збереження шляху та множину для відстеження відвіданих вершин
        LinkedList<Integer> path = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        // Викликаємо метод пошуку шляху в глибину (DFS) та виведення результату
        System.out.println(findPathDfs(vertexZero, vertexFive, path, visited));

        printBfs(vertexFour);
        System.out.println();

        System.out.println(findPathBfs(vertexFive, vertexTwo));

    }

    // Метод для обходу графа в глибину (DFS)
    public static void printDFS(Vertex vertex, Set<Vertex> reachedVertexes) {
        // Якщо вершина вже була відвідана, виходимо з методу
        if (reachedVertexes.contains(vertex)){
            return;
        }

        // Виводимо значення поточної вершини та додаємо її до множини відвіданих вершин
        System.out.print(vertex.value + " ");
        reachedVertexes.add(vertex);

        // Рекурсивно викликаємо метод для всіх сусідніх вершин
        for (Vertex currentVertex : vertex.neighbours){
            printDFS(currentVertex, reachedVertexes);
        }
    }

    // Метод для пошуку шляху в графі в глибину (DFS)
    public static boolean findPathDfs(Vertex from, Vertex to, LinkedList<Integer> path, Set<Vertex> visited) {
        // Виводимо поточну вершину
        System.out.println(from);

        // Якщо вершина вже була відвідана, повертаємо false
        if (visited.contains(from)){
            return false;
        }

        // Додаємо значення поточної вершини до шляху
        path.push(from.value);

        // Якщо досягнули цільову вершину, повертаємо true
        if (from == to){
            return true;
        }

        // Додаємо поточну вершину до множини відвіданих
        visited.add(from);
        boolean found = false;

        // Рекурсивно викликаємо метод для всіх сусідніх вершин поточної вершини
        for(Vertex neighbour : from.neighbours){
            // Викликаємо метод findPathDfs для кожної сусідньої вершини
            // та оновлюємо значення змінної found, використовуючи логічне "або"
            // Якщо знайдено шлях до цільової верш-ини в одній з сусідніх вершин,
            // змінна found буде встановлена в true
            found = found || findPathDfs(neighbour, to, path, visited);
        }


        // Якщо шлях не знайдено, видаляємо останню вершину зі шляху та повертаємо false
        if (!found){
            path.pop();
            return false;
        } else {
            return true;
        }
    }

    // Метод для обходу графа в ширину (BFS)
    public static void printBfs(Vertex start) {
        // Створюємо чергу для зберігання вершин, які потрібно обробити
        Queue<Vertex> queue = new LinkedList<>();
        // Створюємо множину для відстеження відвіданих вершин
        Set<Vertex> visited = new HashSet<>();

        // Додаємо початкову вершину у чергу та відзначаємо її як відвідану
        queue.offer(start);
        visited.add(start);

        // Поки черга не порожня, продовжуємо обробку вершин
        while (!queue.isEmpty()){
            // Вибираємо вершину з початку черги
            Vertex currentVertex = queue.poll();
            // Виводимо значення поточної вершини (або виконуємо потрібну операцію)
            System.out.print(currentVertex + " ");

            // Перебираємо всіх сусідів поточної вершини
            for (Vertex neighbour : currentVertex.neighbours){
                // Якщо сусідня вершина ще не була відвідана
                if (!visited.contains(neighbour)){
                    // Додаємо її у чергу для подальшої обробки
                    queue.offer(neighbour);
                    // Відзначаємо сусідню вершину як відвідану
                    visited.add(neighbour);
                }
            }
        }
    }


    // Метод для пошуку найкоротшого шляху в графі в ширину (BFS)
    public static List<Vertex> findPathBfs(Vertex start, Vertex dest) {
        // Створюємо чергу для зберігання вершин, які потрібно обробити
        Queue<Vertex> queue = new LinkedList<>();
        // Створюємо множину для відстеження відвіданих вершин
        Set<Vertex> visited = new HashSet<>();

        // Додаємо початкову вершину у чергу та відзначаємо її як відвідану
        queue.offer(start);
        visited.add(start);

        // Створюємо список для зберігання шляху від початкової до цільової вершини
        List<Vertex> path = new ArrayList<>();

        // Поки черга не порожня, продовжуємо обробку вершин
        while (!queue.isEmpty()){
            // Вибираємо вершину з початку черги
            Vertex currentVertex = queue.poll();

            // Перевіряємо, чи поточна вершина є цільовою
            if (currentVertex == dest){
                // Якщо так, знаходимо шлях від початкової до цільової вершини
                while (currentVertex.prev != null){
                    currentVertex = currentVertex.prev;
                    path.add(currentVertex);
                }
                // Додаємо цільову вершину до шляху та повертаємо його
                Collections.reverse(path);
                path.add(dest);
                return path;
            }

            // Перебираємо всіх сусідів поточної вершини
            for (Vertex neighbour : currentVertex.neighbours){
                // Якщо сусідня вершина ще не була відвідана
                if (!visited.contains(neighbour)){
                    // Додаємо її у чергу для подальшої обробки
                    queue.offer(neighbour);
                    // Відзначаємо сусідню вершину як відвідану
                    visited.add(neighbour);
                    // Встановлюємо попередню вершину для сусідньої вершини
                    neighbour.prev = currentVertex;
                }
            }
        }
        // Якщо шлях не знайдено, повертаємо порожній список
        return new ArrayList<>();
    }

}
