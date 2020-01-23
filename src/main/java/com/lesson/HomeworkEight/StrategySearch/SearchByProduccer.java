package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

import java.util.Map;


public class SearchByProduccer implements SearchStrategy {



    @Override
    public void search() {
        TaxiPark taxiPark = TaxiPark.getInstance();
        System.out.println("Введите проиводителя:");
        String tmp = readValue();
        for (Map.Entry<Car, Integer> map : taxiPark.getMapCar().entrySet()) {
            if (map.getKey().getProducer().toString().equalsIgnoreCase(tmp)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }
    }
}
