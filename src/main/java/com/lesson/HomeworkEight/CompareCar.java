package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.Car;

import java.util.Comparator;
import java.util.Map;

public class CompareCar implements Comparator<Map.Entry<Car, Integer>> {

    @Override
    public int compare(Map.Entry<Car, Integer> o1, Map.Entry<Car, Integer> o2) {
        return (int) Math.round(100.0 * (o1.getKey().getFuelConsumption() - o2.getKey().getFuelConsumption()));
    }
}
