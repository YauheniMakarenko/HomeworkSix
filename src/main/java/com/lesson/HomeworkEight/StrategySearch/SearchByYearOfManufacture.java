package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

import java.util.Map;


public class SearchByYearOfManufacture implements SearchStrategy {


    @Override
    public void search() {
        TaxiPark taxiPark = TaxiPark.getInstance();
        try {
            System.out.println("Введите год выпуска:");
            int tmp = Integer.parseInt(readValue());
            if (tmp < 0) {
                System.out.println("Указано отрицательное значение! Введите новое");
                tmp = Integer.parseInt(readValue());
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
