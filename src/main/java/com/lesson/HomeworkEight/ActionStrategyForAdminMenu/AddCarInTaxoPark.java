package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.Menu.AdminMenu;

import java.util.Scanner;

public class AddCarInTaxoPark implements ActionStrategyForAdmin {
    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите производителя: ");
        String producer = scanner.next().toUpperCase();
        System.out.println("Введите модель: ");
        String model = scanner.next();
        System.out.println("Введите класс авто (A, B, С, D, E, F, J, M, S): ");
        String carClass = scanner.next().toUpperCase();
        System.out.println("Введите тип кузова (HATCHBACK, SEDAN, UNIVERSAL, COUPE, CABRIOLET, SUV, CROSSOVER, PICKUP, VAN, MINIVAN, LIMOUSINE, RODSTER,): ");
        String bodyType = scanner.next().toUpperCase();
        System.out.println("Введите тип привода (FRONT, REAR, FULL): ");
        String typeOfDrive = scanner.next().toUpperCase();
        System.out.println("Введите цену: ");
        int price = scanner.nextInt();
        System.out.println("Введите год выпуска: ");
        int year = scanner.nextInt();
        System.out.println("Введите максимальную скорость: ");
        int maxSpeed = scanner.nextInt();
        System.out.println("Введите расход топлива: ");
        double fuelConsumption = scanner.nextDouble();
        Car car = new Car(producer, model, CarClass.valueOf(carClass), BodyType.valueOf(bodyType), TypeOfDrive.valueOf(typeOfDrive), price, year, maxSpeed, fuelConsumption);
        AdminMenu.getTaxiPark().addCar(car);
        System.out.println("Автомобиль добавлен в таксопарк!");


    }
}
