package com.lesson.HomeworkEight;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for(Map.Entry<Car, Integer> map : mapCar.entrySet()){
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        System.out.println("Сost of all cars: " + sum);
    }

}
