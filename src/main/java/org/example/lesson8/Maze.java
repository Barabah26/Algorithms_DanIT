package org.example.lesson8;

import org.example.lesson8.GraphEx.Vertex;

import java.util.*;

public class Maze {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 0, 1},
                {1, 0, 1},
                {0, 1, 0},
        };
        Vertex[][] vertexMatrix = createGraph(nums); // Створюємо граф з матриці

        printMatrix(vertexMatrix); // Виводимо матрицю графу

    }

    // Метод для створення графу на основі матриці
    public static Vertex[][] createGraph(int[][] matrix) {
        Vertex[][] vertexMatrix = new Vertex[matrix.length][matrix[0].length]; // Ініціалізуємо матрицю вершин

        // Проходимося по кожному елементу матриці і створюємо відповідну вершину
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Vertex currentVertex = new Vertex(matrix[i][j]); // Створюємо нову вершину з відповідним значенням
                vertexMatrix[i][j] = currentVertex; // Додаємо вершину до матриці графу
            }
        }

        // Додаємо сусідів для кожної вершини згідно з сусідством у вхідній матриці
        for (int i = 0; i < vertexMatrix.length; i++) {
            for (int j = 0; j < vertexMatrix[i].length; j++) {
                if(vertexMatrix[i][j] != null && i > 0 && vertexMatrix[i - 1][j] != null){
                    // Додаємо вершини як сусідів один одного
                    vertexMatrix[i][j].neighbours.add(vertexMatrix[i - 1][j]);
                    vertexMatrix[i-1][j].neighbours.add(vertexMatrix[i][j]);
                }
            }
        }

        return vertexMatrix; // Повертаємо матрицю графу
    }
    public static List<String> printPathDFSInterface(Vertex[][] matrix, int sourceX, int sourceY, int destX, int destY){
        LinkedList<Integer> list = new LinkedList<>();
        printPathDFS(matrix, sourceX, sourceY, destX, destY, list);
        List<String> path = new ArrayList<>(list.stream().map(String::valueOf).toList());
        Collections.reverse(path);
        return path;
    }
    public static void printPathDFS(Vertex[][] matrix, int sourceX, int sourceY, int destX, int destY, LinkedList<Integer> path){
        GraphEx.findPathDfs(matrix[sourceX][sourceY], matrix[destX][destY], path, new HashSet<>());
    }
    public static void printMatrix(Vertex[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
