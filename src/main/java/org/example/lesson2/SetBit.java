package org.example.lesson2;

public class SetBit {
    public static void main(String[] args) {
        // Викликаємо метод setBit() для встановлення біта в певній позиції числа 2000000194 на 1.
        Integer data = setBit(2000000194, 31, 1);

        // Виводимо бінарне представлення отриманого числа.
        System.out.println(Integer.toBinaryString(data));

        // Виводимо отримане число.
        System.out.println(data);

        // Виводимо бінарне представлення отриманого числа (другий раз).
        System.out.println(Integer.toBinaryString(data));
    }

    private static int setBit(int data, int pos, int val){
        // Визначаємо маску, зсуваючи 1 на позицію pos зліва.
        // Наприклад, якщо pos = 3, то mask буде 000...0001000...00, де кількість нулів і одиниць визначається розрядністю int (32 біти).
        int mask = 1 << 31 - pos;

        // Якщо val == 1, встановлюємо вказаний біт за допомогою операції "or".
        if (val == 1){
            // Використовуємо побітовий оператор "or" (|) для встановлення біту в data.
            // При цьому встановлюється біт в позиції pos, який визначено маскою mask.
            return data | mask;
        } else { // Інакше, знімаємо вказаний біт за допомогою операції "and" з запереченням маски.
            // Використовуємо побітовий оператор "and" (&) з запереченням маски (~mask),
            // щоб забезпечити зняття біту в data в позиції pos.
            return data & ~mask;
        }
    }

}
