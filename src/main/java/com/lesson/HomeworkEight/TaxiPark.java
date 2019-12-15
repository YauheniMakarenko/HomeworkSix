package com.lesson.HomeworkEight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaxiPark {
    private Map<Car, Integer> mapCar = new HashMap<>();
    private int sum = 0;


    public void addCar(Car car) {
        if (car == null) {
            return;
        }
        if (!mapCar.containsKey(car)) {
            mapCar.put(car, 1);
            sum += car.getPrice();
        } else {
            mapCar.put(car, mapCar.get(car) + 1);
            sum += car.getPrice();
        }
    }

    public void addCar(List<Car> list) {
        for (int i = 0; i < list.size(); i++) {
            addCar(list.get(i));
        }
    }

    public void print() {
        for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        System.out.println("--------------------------------------------");
        System.out.println("Сost of all cars: " + sum);
    }

    public Map<Car, Integer> getMapCar() {
        return mapCar;
    }

    public void sort() {
        List list = new ArrayList(getMapCar().entrySet());
        Collections.sort(list, new CompareCar());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void topByPrice() {
        List list = new ArrayList(getMapCar().entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Car, Integer>>() {
            @Override
            public int compare(Map.Entry<Car, Integer> o1, Map.Entry<Car, Integer> o2) {
                return o1.getKey().getPrice() - o2.getKey().getPrice();
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }

    public void topByMaxSpeed() {
        List list = new ArrayList(getMapCar().entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Car, Integer>>() {
            @Override
            public int compare(Map.Entry<Car, Integer> o1, Map.Entry<Car, Integer> o2) {
                return o1.getKey().getMaxSpeed() - o2.getKey().getMaxSpeed();
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }

    private String reader() {
        String string = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public void searchByPrice() {
        try {
            System.out.println("Введите минимальную цену:");
            int tmpMin = Integer.parseInt(reader());
            System.out.println("Введите максимальную цену:");
            int tmpMax = Integer.parseInt(reader());
            if (tmpMax < tmpMin) {
                System.out.println("Указанное значение меньше минимальной цены, укажите другую максимальную цену:");
                tmpMax = Integer.parseInt(reader());
            }
            for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
                if (map.getKey().getPrice() >= tmpMin && map.getKey().getPrice() <= tmpMax) {
                    System.out.println(map.getKey() + ":" + map.getValue());
                }
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
            System.out.println("Ошибка! Неверный формат ввода данных.");
            //searchByPrice();
        }
    }

    public void searchByYearOfManufacture() {
        try {
            System.out.println("Введите год выпуска:");
            int tmp = Integer.parseInt(reader());
            if (tmp < 0) {
                System.out.println("Указано отрицательное значение! Введите новое");
                tmp = Integer.parseInt(reader());
            }
            for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
                if (map.getKey().getYear() == tmp) {
                    System.out.println(map.getKey() + ":" + map.getValue());
                }
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
            System.out.println("Ошибка! Неверный формат ввода данных.");
            searchByYearOfManufacture();
        }
    }

    public void searchByProduccer() {
        System.out.println("Введите проиводителя:");
        String tmp = reader();
        for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
            if (map.getKey().getProducer().toString().equalsIgnoreCase(tmp)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }

    }

    public void searchByTwoParameters() {
        System.out.println("Введите производителя:");
        String firstParameter = reader();
        System.out.println("Введите класс авто: (A/S)");
        System.out.println("A-микроавто, B-малые авто, С-средний, D-семейные, E-бизнес, F-представительские" +
                ", J-внедорожники, M-минивены, S-спорткар");
        String secondParameter = reader();
        for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
            if (map.getKey().getProducer().toString().equalsIgnoreCase(firstParameter)
                    && map.getKey().getCarСlass().toString().equalsIgnoreCase(secondParameter)) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        }


    }

}
