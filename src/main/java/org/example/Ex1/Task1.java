package org.example.Ex1;

import java.util.*;

/*1. В стране Лимпопо количество всех зверей равно 10 миллионов.
Рождаемость составляет 14 зверей на 1000, смертность - 8 зверей.
Рассчитайте, сколько зверей будет через 10 лет, принимая во внимание,
что показатели рождаемости и смертности постоянны. */

public class Task1 {
    public static void main(String[] args) {
        int fertilityAnimals = 14;
        int mortalityAnimals = 8;
        int initialPopulation = 10000000;
        int increaseAnimals = (fertilityAnimals - mortalityAnimals) * initialPopulation / 1000;
        int years = 10;
        int countYears = 0;

        List<String> animals = new ArrayList<>(10);
        for (int i = 0; i < years; i++) {
            animals.add("200" + i);
        }

        Iterator<String> iterator = animals.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            initialPopulation += increaseAnimals;
            animals.set(countYears, animals.get(countYears) + " было " + initialPopulation + " животных\n");
            countYears++;
        }
        System.out.println(animals);
    }
}
