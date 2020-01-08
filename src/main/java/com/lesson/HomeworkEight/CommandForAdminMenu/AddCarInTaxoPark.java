package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.TaxiPark;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCarInTaxoPark implements CommandsForAdmin {

    ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите производителя: ");
        String producer = scanner.next().toUpperCase();
        System.out.println("Введите модель: ");
        String model = scanner.next();
        System.out.println("Введите класс авто (A, B, С, D, E, F, J, M, S): ");
        String carClass = scanner.next().toUpperCase();
        System.out.println("Введите тип кузова (HATCHBACK, SEDAN, UNIVERSAL, COUPE, CABRIOLET, SUV, CROSSOVER, PICKUP, VAN, MINIVAN, LIMOUSINE, RODSTER): ");
        String bodyType = scanner.next().toUpperCase();
        System.out.println("Введите тип привода (FRONT, REAR, FULL): ");
        String typeOfDrive = scanner.next().toUpperCase();
        System.out.println("Введите цену: ");
        String priceString = scanner.next();
        while (!validatorForMenu.validate(priceString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            System.out.println("Введите цену: ");
            priceString = scanner.next();
        }
        int price = Integer.parseInt(priceString);

        System.out.println("Введите год выпуска: ");
        String yearString = scanner.next();
        while (!validatorForMenu.validate(yearString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            System.out.println("Введите год выпуска: ");
            yearString = scanner.next();
        }
        int year = Integer.parseInt(yearString);

        System.out.println("Введите максимальную скорость: ");
        String maxSpeedString = scanner.next();
        while (!validatorForMenu.validate(maxSpeedString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            System.out.println("Введите максимальную скорость: ");
            maxSpeedString = scanner.next();
        }
        int maxSpeed = Integer.parseInt(maxSpeedString);

        System.out.println("Введите расход топлива: ");
        String fuelConsumprionString = scanner.next();
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(fuelConsumprionString);
        while (!matcher.matches()){
            System.out.println("Вы ввели некорректное значение! Попробуйте ввести например (8.7): ");
            System.out.println("Введите расход топлива: ");
            fuelConsumprionString = scanner.next();
        }
        double fuelConsumption = Double.parseDouble(fuelConsumprionString);

        Car car = new Car(producer, model, CarClass.valueOf(carClass), BodyType.valueOf(bodyType), TypeOfDrive.valueOf(typeOfDrive), price, year, maxSpeed, fuelConsumption);
        TaxiPark.createSingletonTaxiPark().addCar(car);
        System.out.println("Автомобиль добавлен в таксопарк!");


    }
}
