package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.SortStrategy.SortStrategy;
import com.lesson.HomeworkEight.StrategySearch.SearchStrategy;

import java.util.*;

public class TaxiPark {
    private Map<Car, Integer> mapCar = new HashMap<>();
    private int sum;
    private SearchStrategy searchStrategy;
    private SortStrategy sortStrategy;

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
        System.out.println("Список всех автомобилей");
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

    public void topBy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
        sortStrategy.sort();
    }


    public void search(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
        searchStrategy.search();
    }
}
