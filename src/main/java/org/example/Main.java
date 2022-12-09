package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List list = new List(3);
        List list2 = new List(3);

        list2.add(1);
//        list2.add(2);

        System.out.println(list.add(2));
        System.out.println(list.add(1,1));
////        System.out.println(list.set(1,3));
////        System.out.println(list.remove(2));
////        System.out.println(list.remove("1"));
//        System.out.println(list.contains(5));
//        System.out.println(list.indexOf(1));
//        System.out.println(list.lastIndexOf(1));
//        System.out.println(list.get(0));
//        System.out.println(list.equals(list2));
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
////        list.clear();
//        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(list.sort()));
//        Integer[] integers = new Integer[100_000];
//        generateNumbers(integers);
//        long start = System.currentTimeMillis();
//        sort(integers);
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(Arrays.toString(integers));
    }

    private static void sort(Integer[] arr) {
        Arrays.sort(arr);
    }

    private static void generateNumbers(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = ((int) (Math.random() * 1000000));
        }
    }
}