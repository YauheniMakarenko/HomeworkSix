package com.lesson.HomeworkEight.TaxiPark;

import com.lesson.HomeworkEight.Car;

import java.util.Map;

public interface ITaxiPark {
    void addCar(Car car);
    Map<Car, Integer> getMapCar();
    int getCostOfCars();
    void sort();
}
