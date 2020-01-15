package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class SearchByProduccer implements SearchStrategy {

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
        TaxiPark taxiPark = TaxiPark.getInstance();
        System.out.println("Введите проиводителя:");
        String tmp = reader();
        for (Map.Entry<Car, Integer> map : taxiPark.getMapCar().entrySet()) {
            if (map.getKey().getProducer().toString().equalsIgnoreCase(tmp)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }
    }
}
