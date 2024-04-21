package org.example.lesson9;

import java.util.LinkedList;
import java.util.Queue;

public class Lee {

    // Enumeration для стану клітинки
    enum State {
        EMPTY, // пуста
        OBSTACLE, // перешкода
        START, // початок
        TARGET, // ціль
        PATH // шлях
    }

    // Клас для представлення координат клітинки в сітці
    static class Cell {
        int row; // рядок
        int col; // стовпець

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // Функція для пошуку найкоротшого шляху
    public static void shortestPath(int[][] grid, Cell start, Cell target) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Масив напрямків руху
        int rows = grid.length; // Кількість рядків у сітці
        int cols = grid[0].length; // Кількість стовпців у сітці

        Queue<Cell> queue = new LinkedList<>(); // Черга для обробки клітин
        queue.offer(start); // Додаємо початкову клітину в чергу

        // Поки черга не пуста
        while (!queue.isEmpty()) {
            Cell current = queue.poll(); // Беремо клітину з початку черги

            // Перевіряємо, чи досягли ми цільової клітинки
            if (current.row == target.row && current.col == target.col) {
                // Досягли цільової клітинки, завершуємо цикл
                break;
            }

            // Перебираємо всі можливі напрямки руху
            for (int[] direction : directions) {
                int newRow = current.row + direction[0]; // Новий рядок
                int newCol = current.col + direction[1]; // Новий стовпець

                // Перевіряємо, чи нова клітина знаходиться всередині меж сітки та є доступною для проходу
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                    // Додаємо нову клітину до черги
                    queue.offer(new Cell(newRow, newCol));
                    // Встановлюємо нове значення для клітини шляху
                    grid[newRow][newCol] = grid[current.row][current.col] + 1;
                }
            }
        }

        // Відновлюємо шлях
        int length = grid[target.row][target.col]; // Довжина шляху
        Cell current = target; // Поточна клітина для відновлення шляху
        while (grid[current.row][current.col] != 2) {
            // Проходимо назад по шляху та відновлюємо його
            for (int[] direction : directions) {
                int newRow = current.row + direction[0]; // Новий рядок
                int newCol = current.col + direction[1]; // Новий стовпець
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == length - 1) {
                    // Позначаємо клітину шляху
                    grid[newRow][newCol] = 2;
                    length--; // Зменшуємо довжину шляху
                    current = new Cell(newRow, newCol); // Оновлюємо поточну клітину
                    break;
                }
            }
        }

        // Виведення найкоротшого шляху
        System.out.println("Найкоротший шлях:");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == start.row && j == start.col) {
                    System.out.print("S "); // Початкова клітина
                } else if (i == target.row && j == target.col) {
                    System.out.print("T "); // Цільова клітина
                } else if (grid[i][j] == 1) {
                    System.out.print("# "); // Перешкода
                } else if (grid[i][j] == 2) {
                    System.out.print("X "); // Клітина шляху
                } else {
                    System.out.print("_ "); // Пуста клітина
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // Приклад використання
        int[][] grid = {
                {0, 0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };

        Cell start = new Cell(0, 0); // початкова клітина
        Cell target = new Cell(4, 5); // цільова клітина

        shortestPath(grid, start, target);
    }
}
