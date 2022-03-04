package com.choi.weplay.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 3, 1, 5);

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(Arrays.equals(list1.toArray(),list2.toArray()));
    }
}
