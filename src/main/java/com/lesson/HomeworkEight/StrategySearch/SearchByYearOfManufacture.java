package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


public class SearchByYearOfManufacture implements SearchStrategy {

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
        try {
            System.out.println("Введите год выпуска:");
            int tmp = Integer.parseInt(reader());
            if (tmp < 0) {
                System.out.println("Указано отрицательное значение! Введите новое");
                tmp = Integer.parseInt(reader());
            }
            for (Map.Entry<Car, Integer> map : taxiPark.getMapCar().entrySet()) {
                if (map.getKey().getYear() == tmp) {
                    System.out.println(map.getKey() + ":" + map.getValue());
                }
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
            System.out.println("Ошибка! Неверный формат ввода данных.");
            search();
        }
    }
}
