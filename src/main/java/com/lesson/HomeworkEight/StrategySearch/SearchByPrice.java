package com.lesson.HomeworkEight.StrategySearch;

import com.lesson.HomeworkEight.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static com.lesson.HomeworkEight.TaxiPark.getMapCar;

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
        int[] array = new int[2];
        try {
            System.out.println("Введите минимальную цену:");
            int tmpMin = Integer.parseInt(reader());
            array[0] = tmpMin;
            System.out.println("Введите максимальную цену:");
            int tmpMax = Integer.parseInt(reader());
            array[1] = tmpMax;
            if (tmpMax < tmpMin) {
                System.out.println("Указанное значение меньше минимальной цены, укажите другую максимальную цену:");
                tmpMax = Integer.parseInt(reader());
                array[1] = tmpMax;
            }
            for (Map.Entry<Car, Integer> map : getMapCar().entrySet()) {
                if (map.getKey().getPrice() >= array[0] && map.getKey().getPrice() <= array[1]) {
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
