package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static com.lesson.HomeworkEight.TaxiPark.getMapCar;

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
        int[] array = new int[1];
        try {
            System.out.println("Введите год выпуска:");
            int tmp = Integer.parseInt(reader());
            array[0] = tmp;
            if (tmp < 0) {
                System.out.println("Указано отрицательное значение! Введите новое");
                tmp = Integer.parseInt(reader());
                array[0] = tmp;
            }
            for (Map.Entry<Car, Integer> map : getMapCar().entrySet()) {
                if (map.getKey().getYear() == array[0]) {
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
