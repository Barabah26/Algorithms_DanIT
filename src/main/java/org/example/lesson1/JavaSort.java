package org.example.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JavaSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 2);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        int[] array = {1, 4, 2, 0};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
