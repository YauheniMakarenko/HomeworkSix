package com.lesson.HomeworkEight;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
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
        for (int i = 0; i < list.size(); i++) {
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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void searchByPrice() throws IOException {
        try {
            System.out.println("Введите минимальную цену:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double tmpMin = Double.parseDouble(reader.readLine());
            System.out.println("Введите максимальную цену:");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            double tmpMax = Double.parseDouble(reader1.readLine());
            if (tmpMax < tmpMin) {
                System.out.println("Указанное значение меньше минимальной цены, укажите другую максимальную цену:");
                tmpMax = Double.parseDouble(reader1.readLine());
            }
            for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
                if (map.getKey().getPrice() >= tmpMin && map.getKey().getPrice() <= tmpMax) {
                    System.out.println(map.getKey() + ":" + map.getValue());
                }
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
            System.out.println("Ошибка! Неверный формат ввода данных.");
            searchByPrice();
        }
    }

    public void searchByYearOfManufacture() throws IOException {
        try {
            System.out.println("Введите год выпуска:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double tmp = Double.parseDouble(reader.readLine());
            if (tmp < 0) {
                System.out.println("Указано отрицательное значение! Введите новое");
                tmp = Double.parseDouble(reader.readLine());
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
        try {
            System.out.println("Введите проиводителя:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String tmp = reader.readLine();
            for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
                if (map.getKey().getProducer().toString().equalsIgnoreCase(tmp)) {
                    System.out.println(map.getKey() + ":" + map.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchByTwoParameters() {
        try {
            System.out.println("Введите производителя:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstParameter = reader.readLine();
            System.out.println("Введите класс авто: (A/S)");
            System.out.println("A-микроавто, B-малые авто, С-средний, D-семейные, E-бизнес, F-представительские" +
                    ", J-внедорожники, M-минивены, S-спорткар");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String secondParameter = reader1.readLine();
            for (Map.Entry<Car, Integer> map : mapCar.entrySet()) {
                if (map.getKey().getProducer().toString().equalsIgnoreCase(firstParameter)
                        && map.getKey().getCarСlass().toString().equalsIgnoreCase(secondParameter)) {
                    System.out.println(map.getKey() + ":" + map.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
