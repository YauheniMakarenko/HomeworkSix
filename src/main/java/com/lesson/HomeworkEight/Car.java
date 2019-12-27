package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;

import java.util.Objects;

public class Car {
    private String producer;
    private String model;
    private CarClass carСlass;
    private BodyType bodyType;
    private TypeOfDrive typeOfDrive;
    private int price;
    private int year;
    private int maxSpeed;
    private double fuelConsumption;

    public Car(String producer, String model, CarClass carClass, BodyType bodyType, TypeOfDrive typeOfDrive, int price, int year,int maxSpeed, double fuelConsumption) {
        this.producer = producer;
        this.model = model;
        this.carСlass = carClass;
        this.bodyType = bodyType;
        this.typeOfDrive = typeOfDrive;
        this.price = price;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }


    public String getProducer() {
        return producer;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getModel() {
        return model;
    }

    public CarClass getCarСlass() {
        return carСlass;
    }

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer=" + producer +
                ", model='" + model + '\'' +
                ", carСlass=" + carСlass +
                ", bodyType=" + bodyType +
                ", typeOfDrive=" + typeOfDrive +
                ", price=" + price +
                ", year=" + year +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price &&
                year == car.year &&
                maxSpeed == car.maxSpeed &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                Objects.equals(producer, car.producer) &&
                Objects.equals(model, car.model) &&
                carСlass == car.carСlass &&
                bodyType == car.bodyType &&
                typeOfDrive == car.typeOfDrive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, carСlass, bodyType, typeOfDrive, price, year, maxSpeed, fuelConsumption);
    }
}
