package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

import java.util.Map;


public class SearchByTwoParamerts implements SearchStrategy {

    @Override
    public void search() {
        TaxiPark taxiPark = TaxiPark.getInstance();
        System.out.println("Введите производителя:");
        String firstParameter = readValue();
        System.out.println("Введите класс авто: (A/S)");
        System.out.println("A-микроавто, B-малые авто, С-средний, D-семейные, E-бизнес, F-представительские" +
                ", J-внедорожники, M-минивены, S-спорткар");
        String secondParameter = readValue();
        for (Map.Entry<Car, Integer> map : taxiPark.getMapCar().entrySet()) {
            if (map.getKey().getProducer().equalsIgnoreCase(firstParameter)
                    && map.getKey().getCarСlass().toString().equalsIgnoreCase(secondParameter)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }
    }
}
