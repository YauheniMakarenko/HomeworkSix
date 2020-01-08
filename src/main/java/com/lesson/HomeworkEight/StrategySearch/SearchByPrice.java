package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Menu.AdminMenu;
import com.lesson.HomeworkEight.TaxiPark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class SearchByPrice implements SearchStrategy {

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
        try {
            System.out.println("Введите минимальную цену:");
            int tmpMin = Integer.parseInt(reader());
            System.out.println("Введите максимальную цену:");
            int tmpMax = Integer.parseInt(reader());
            if (tmpMax < tmpMin) {
                System.out.println("Указанное значение меньше минимальной цены, укажите другую максимальную цену:");
                tmpMax = Integer.parseInt(reader());
            }
            for (Map.Entry<Car, Integer> map : taxiPark.getMapCar().entrySet()) {
                if (map.getKey().getPrice() >= tmpMin && map.getKey().getPrice() <= tmpMax) {
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
