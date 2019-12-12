package com.lesson.HomeworkEight;

import java.util.Comparator;
import java.util.Map;

public class CompareCar implements Comparator<Map.Entry<Car, Integer>> {

    @Override
    public int compare(Map.Entry<Car, Integer> o1, Map.Entry<Car, Integer> o2) {
        return (int) (o1.getKey().getFuelConsumption() - o2.getKey().getFuelConsumption());
    }
}
