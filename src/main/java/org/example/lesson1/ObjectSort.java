package org.example.lesson1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ObjectSort {
    public static void main(String[] args) {
        Comparator<Card> cardComparator = Comparator.comparing(Card::value)
                .thenComparing(Card::suit);

        List<Card> list = Arrays.asList(
                new Card(2, Suit.CLUBS),
                new Card(2, Suit.HEARTS),
                new Card(1, Suit.SPADES)
        );

        Comparator<Card> simpleComp = Comparator.comparing(Card::value);
        list.sort(cardComparator);
        System.out.println(list);
    }

    enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS
    }

    record Card(
            int value,
            Suit suit
    ) {
    }
}
