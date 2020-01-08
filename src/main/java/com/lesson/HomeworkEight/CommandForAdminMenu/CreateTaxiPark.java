package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.Enum.BodyType;
import com.lesson.HomeworkEight.Enum.CarClass;
import com.lesson.HomeworkEight.Enum.TypeOfDrive;
import com.lesson.HomeworkEight.File.ReadJSON;
import com.lesson.HomeworkEight.TaxiPark;
import com.lesson.HomeworkEight.Validators.ValidatorForFileName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateTaxiPark implements CommandsForAdmin {

    ValidatorForFileName validatorForFileName = new ValidatorForFileName();

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла!");
        String select = scanner.next();
        while (!validatorForFileName.validate(select)) {
            System.out.println("Имя файла некорректное, пожалуйста, введите имя файла например: \"car.json\": ");
            select = scanner.next();
        }
        try {
            ReadJSON productFileReadJSON = new ReadJSON();
            TaxiPark.createSingletonTaxiPark().addCar(productFileReadJSON.createLispProductFile(select));
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Ошибка! Данного файла не обнаружено!");
            System.out.println("Данные загружены из Main");
            TaxiPark.createSingletonTaxiPark().addCar(add());
        }
    }

    public List add() {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car("NISSAN", "GT-R", CarClass.S, BodyType.SEDAN, TypeOfDrive.REAR, 32000, 1995, 300, 20));
        listCar.add(new Car("NISSAN", "GT-R", CarClass.S, BodyType.SEDAN, TypeOfDrive.REAR, 32000, 1995, 300, 20));
        listCar.add(new Car("MERCEDESBENZ", "CLS-63-AMG", CarClass.D, BodyType.COUPE, TypeOfDrive.FULL, 110000, 2019, 250, 15));
        listCar.add(new Car("MERCEDESBENZ", "AMG-G63", CarClass.J, BodyType.SUV, TypeOfDrive.FULL, 120000, 2019, 250, 13));
        listCar.add(new Car("MERCEDESBENZ", "Maybach-S-650-Guard", CarClass.F, BodyType.SEDAN, TypeOfDrive.FULL, 1000000, 2019, 190, 8.7));
        listCar.add(new Car("HYUNDAI", "Solaris", CarClass.B, BodyType.SEDAN, TypeOfDrive.FULL, 4500, 2017, 190, 5.7));
        listCar.add(new Car("HYUNDAI", "Solaris", CarClass.B, BodyType.SEDAN, TypeOfDrive.FULL, 4500, 2017, 190, 5.7));
        listCar.add(new Car("KIA", "Rio", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 11000, 2017, 190, 3.8));
        listCar.add(new Car("SKODA", "Rapid", CarClass.C, BodyType.SEDAN, TypeOfDrive.FRONT, 12500, 2012, 190, 5.6));
        listCar.add(new Car("RENAULT", "Logan", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2004, 175, 7.9));
        listCar.add(new Car("RENAULT", "Logan", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2004, 175, 7.9));
        listCar.add(new Car("RENAULT", "Logan", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2004, 175, 7.9));
        listCar.add(new Car("FORD", "Focus", CarClass.C, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2011, 195, 8.3));
        listCar.add(new Car("TOYOTA", "Camry", CarClass.E, BodyType.SEDAN, TypeOfDrive.FULL, 18000, 2016, 210, 9.7));
        listCar.add(new Car("TOYOTA", "Camry", CarClass.E, BodyType.SEDAN, TypeOfDrive.FULL, 18000, 2016, 210, 9.7));
        listCar.add(new Car("TOYOTA", "Camry", CarClass.E, BodyType.SEDAN, TypeOfDrive.FULL, 18000, 2016, 210, 9.7));
        listCar.add(new Car("TOYOTA", "Camry", CarClass.E, BodyType.SEDAN, TypeOfDrive.FULL, 18000, 2016, 210, 9.7));
        listCar.add(new Car("SKODA", "Octavia", CarClass.C, BodyType.HATCHBACK, TypeOfDrive.FULL, 35000, 2019, 230, 5));
        listCar.add(new Car("SKODA", "Octavia", CarClass.C, BodyType.HATCHBACK, TypeOfDrive.FULL, 35000, 2019, 230, 5));
        listCar.add(new Car("SKODA", "Octavia", CarClass.C, BodyType.HATCHBACK, TypeOfDrive.FULL, 35000, 2019, 230, 5));
        listCar.add(new Car("SKODA", "Octavia", CarClass.C, BodyType.HATCHBACK, TypeOfDrive.FULL, 35000, 2019, 230, 5));
        return listCar;
    }
}
