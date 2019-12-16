package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static com.lesson.HomeworkEight.TaxiPark.getMapCar;

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
        System.out.println("Введите проиводителя:");
        String tmp = reader();
        for (Map.Entry<Car, Integer> map : getMapCar().entrySet()) {
            if (map.getKey().getProducer().toString().equalsIgnoreCase(tmp)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }
    }
}
