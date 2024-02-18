package org.example.Ex2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* создать лист, наполнить его 10 млн.элементов
внутри тела просто будем присваивать i-тый элемент в переменную temp
перебрать весь список и замерять время выполнения:
  а) с помощью for-each loop
  b) классический for, с выполнением условия i<list.size()
  c) классический for, но проходим список с конца до начала (i--)
  d) используя Itertor
  e) используя ListIterator и перемещаясь от начала списка до конца
  e) используя ListIterator с перемещением от конца списка к началу
Замер производительности делать для каждого из подпунктов отдельно,
используя например сходный шаблон кода:  инструкцию java:
       long startTime = System.currentTimeMillis();
       //…… Ваша реализация перебора списка, например
       for (int i : list) {
           int temp = i;
       }
       long endTime = System.currentTimeMillis();
       System.out.println("for-each loop: " + (endTime - startTime));
время выполнения каждого перебора вывести в консоль
Определите, какой вариант перебора списка работает быстрее всего.*/

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        optionA(list);
        optionB(list);
        optionC(list);
        optionD(list);
        optionE(list);
        optionF(list);
    }

    private static void optionF(List<Integer> list) {
        // используя ListIterator с перемещением от конца списка к началу
        long startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            int temp = iterator.previous();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с помощью ListIterator и перемещаясь от конца списка к началу: "
                + (endTime - startTime) + " миллисекунды");
    }

    private static void optionE(List<Integer> list) {
        // используя ListIterator и перемещаясь от начала списка до конца
        long startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с помощью ListIterator и перемещаясь от начала списка до конца: "
                + (endTime - startTime) + " миллисекунды");
    }

    private static void optionD(List<Integer> list) {
        // используя Itertor
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с помощью Itertor: " + (endTime - startTime) + " миллисекунды");
    }

    private static void optionC(List<Integer> list) {
        //классический for, но проходим список с конца до начала (i--)
        long startTime = System.currentTimeMillis();
        for (int i = list.size(); i > 0; i--) {
            int temp = i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с помощью классический for, но проходим список с конца до начала (i--): "
                + (endTime - startTime) + " миллисекунды");
    }

    private static void optionB(List<Integer> list) {
        //  классический for, с выполнением условия i<list.size()
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int temp = i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с помощью for-each loop: " + (endTime - startTime) + " миллисекунды");
    }

    private static void optionA(List<Integer> list) {
        // с помощью for-each loop
        long startTime = System.currentTimeMillis();
        for (int i : list) {
            int temp = i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения с помощью i<list.size(): " + (endTime - startTime) + " миллисекунды");
    }
}
