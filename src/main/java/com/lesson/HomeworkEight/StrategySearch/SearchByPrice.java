package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

import java.util.Map;

public class SearchByPrice implements SearchStrategy {

    @Override
    public void search() {
        TaxiPark taxiPark = TaxiPark.getInstance();
        try {
            System.out.println("Введите минимальную цену:");
            int tmpMin = Integer.parseInt(readValue());
            System.out.println("Введите максимальную цену:");
            int tmpMax = Integer.parseInt(readValue());
            if (tmpMax < tmpMin) {
                System.out.println("Указанное значение меньше минимальной цены, укажите другую максимальную цену:");
                tmpMax = Integer.parseInt(readValue());
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
