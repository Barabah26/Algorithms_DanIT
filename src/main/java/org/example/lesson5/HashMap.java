package org.example.lesson5;

import java.util.Map;

// Клас, що реалізує HashMap
public class HashMap<K, V> {
    private static final int CAPACITY = 16; // Початковий розмір таблиці
    private static final double DEFAULT_LOAD_FACTOR = 0.75; // Завантаження за замовчуванням
    private Entry<K, V>[] buckets = new Entry[CAPACITY]; // Масив записів

    // Внутрішній клас, що представляє запис у таблиці
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private K key; // Ключ запису
        private V value; // Значення запису
        private Entry<K, V> next; // Посилання на наступний запис (у випадку колізій)

        // Конструктор запису
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Метод для отримання ключа запису
        @Override
        public K getKey() {
            return key;
        }

        // Метод для отримання значення запису
        @Override
        public V getValue() {
            return value;
        }

        // Метод для встановлення нового значення для запису
        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        // Перевизначений метод toString для зручного виведення запису
        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    // Головний метод, який викликається при запуску програми
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); // Створення нового екземпляра HashMap
        map.put("1", 1); // Додавання деяких значень
        map.put("2", 2);
        map.put("3", 3);
        map.put("43", 43);
        map.put("30", 30);
        map.put("57", 57);
        map.put("58", 58);
        map.put("55", 55);
        map.put("18", 18);
        map.put("19", 44);
        map.put("20", 21);
        map.put("21", 27);
        map.put("22", 77);
        map.put("23", 766);
        map.put("24", 145);
        map.put("25", 678);
        map.put("26", 111);
        map.put("27", 90);
        map.put(null, 155); // Додавання запису з ключем null (для демонстрації обробки)
        System.out.println(map); // Виведення всіх записів HashMap
    }

    // Метод для додавання запису в HashMap
    public void put(K key, V value) {
        int keyHash = hash(key); // Визначення хешу для ключа
        int indexBucket = indexFor(keyHash); // Визначення індексу в масиві бакетів

        // Перевірка, чи вже існує запис з таким ключем у бакеті
        if (buckets[indexBucket] != null) {
            Entry<K, V> entry = buckets[indexBucket];
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return; // Якщо ключ вже існує, не потрібно додавати новий запис
                }
                entry = entry.next; // Перехід до наступного запису
            }
            buckets[indexBucket] = new Entry<>(key, value, buckets[indexBucket]); // Додавання нового запису у початок бакету
        } else {
            buckets[indexBucket] = new Entry<>(key, value, null); // Додавання нового запису як перший у бакеті
        }
    }

    // Метод для визначення індексу бакету за хешем ключа
    private int indexFor(int hash) {
        return hash & (buckets.length - 1); // Застосування побітової маски для визначення індексу
    }

    // Метод для обчислення хеш-коду ключа
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode()); // Використовуємо вбудований метод hashCode для обчислення хешу ключа
    }


    // Перевизначений метод toString для зручного виведення всіх записів HashMap
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Entry<K, V> entry : buckets) {
            while (entry != null) {
                res.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n"); // Додавання запису у вигляді ключа та значення до результуючого рядка
                entry = entry.next; // Перехід до наступного запису
            }
        }
        return res.toString(); // Повернення результуючого рядка
    }

    // Метод для отримання значення за ключем
    public V get(K key) {
        int keyHash = hash(key); // Обчислення хешу для ключа
        int indexBucket = indexFor(keyHash); // Визначення індексу бакету

        // Перевірка, чи є запис з таким ключем у відповідному бакеті
        Entry<K, V> entry = buckets[indexBucket];
        while (entry != null) {
            if (entry.getKey() == null ? key == null : entry.getKey().equals(key)) {
                return entry.getValue(); // Якщо ключ співпадає, повертаємо відповідне значення
            }
            entry = entry.next; // Перехід до наступного запису у бакеті
        }
        return null; // Якщо ключ не знайдено, повертаємо null
    }

}
