package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Menu.AdminMenu;
import com.lesson.HomeworkEight.TaxiPark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class SearchByTwoParamerts implements SearchStrategy {

    private String reader() {
        String string = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    @Override
    public void search() {
        TaxiPark taxiPark = TaxiPark.createSingletonTaxiPark();
        System.out.println("Введите производителя:");
        String firstParameter = reader();
        System.out.println("Введите класс авто: (A/S)");
        System.out.println("A-микроавто, B-малые авто, С-средний, D-семейные, E-бизнес, F-представительские" +
                ", J-внедорожники, M-минивены, S-спорткар");
        String secondParameter = reader();
        for (Map.Entry<Car, Integer> map : taxiPark.getMapCar().entrySet()) {
            if (map.getKey().getProducer().toString().equalsIgnoreCase(firstParameter)
                    && map.getKey().getCarСlass().toString().equalsIgnoreCase(secondParameter)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }
    }
}
