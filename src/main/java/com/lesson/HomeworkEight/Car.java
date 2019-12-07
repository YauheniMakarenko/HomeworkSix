package com.lesson.HomeworkEight;

import java.util.Objects;

public class Car {
    private Producer producer;
    private String model;
    private BodyType bodyType;
    private TypeOfDrive typeOfDrive;
    private int price;
    private int year;
    private int mileAge;
    private int maxSpeed;
    private double fuelConsumption;
    private int weight;
    private boolean automaticTransmission;

    public Car(Producer producer, String model, BodyType bodyType, TypeOfDrive typeOfDrive, int price, int year, int mileAge, int maxSpeed, double fuelConsumption, int weight, boolean automaticTransmission) {
        this.producer = producer;
        this.model = model;
        this.bodyType = bodyType;
        this.typeOfDrive = typeOfDrive;
        this.price = price;
        this.year = year;
        this.mileAge = mileAge;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.weight = weight;
        this.automaticTransmission = automaticTransmission;
    }


    public Producer getProducer() {
        return producer;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getModel() {
        return model;
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

    public int getMileAge() {
        return mileAge;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isAutomaticTransmission() {
        return automaticTransmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer=" + producer +
                ", model='" + model + '\'' +
                ", bodyType=" + bodyType +
                ", typeOfDrive=" + typeOfDrive +
                ", price=" + price +
                ", year=" + year +
                ", mileAge=" + mileAge +
                ", maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", weight=" + weight +
                ", automaticTransmission=" + automaticTransmission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price &&
                year == car.year &&
                mileAge == car.mileAge &&
                maxSpeed == car.maxSpeed &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                weight == car.weight &&
                automaticTransmission == car.automaticTransmission &&
                producer == car.producer &&
                Objects.equals(model, car.model) &&
                bodyType == car.bodyType &&
                typeOfDrive == car.typeOfDrive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, bodyType, typeOfDrive, price, year, mileAge, maxSpeed, fuelConsumption, weight, automaticTransmission);
    }
}
