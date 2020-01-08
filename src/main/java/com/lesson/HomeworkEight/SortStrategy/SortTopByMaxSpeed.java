package com.lesson.HomeworkEight.SortStrategy;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;

public class SortTopByMaxSpeed implements SortStrategy {

    @Override
    public List<Map.Entry<Car, Integer>> sortTop() {
        List list = new ArrayList(TaxiPark.getInstance().getMapCar().entrySet());
        Collections.sort(list, (Comparator<Map.Entry<Car, Integer>>) (o1, o2) -> o2.getKey().getMaxSpeed() - o1.getKey().getMaxSpeed());
        return list;
    }
}
