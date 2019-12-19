package com.lesson.HomeworkEight.SortStrategy;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Menu.AdminMenu;

import java.util.*;

public class SortTopByPrice implements SortStrategy {
    @Override
    public void sortTop() {
        List list = new ArrayList(AdminMenu.getTaxiPark().getMapCar().entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Car, Integer>>() {
            @Override
            public int compare(Map.Entry<Car, Integer> o1, Map.Entry<Car, Integer> o2) {
                return o1.getKey().getPrice() - o2.getKey().getPrice();
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }
}
