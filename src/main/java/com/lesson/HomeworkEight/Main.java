package com.lesson.HomeworkEight;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car(Producer.NISSAN, "GT-R", CarClass.S, BodyType.SEDAN, TypeOfDrive.REAR, 32000, 1995,300, 20));
        listCar.add(new Car(Producer.MERCEDESBENZ, "CLS-63-AMG", CarClass.D, BodyType.COUPE, TypeOfDrive.FULL, 110000, 2019,250, 15));
        listCar.add(new Car(Producer.MERCEDESBENZ, "AMG-G63", CarClass.J, BodyType.SUV, TypeOfDrive.FULL, 120000, 2019, 250, 13));
        listCar.add(new Car(Producer.MERCEDESBENZ, "Maybach S-650-Guard", CarClass.F, BodyType.SEDAN, TypeOfDrive.FULL, 1000000, 2019,190, 8.7));
        listCar.add(new Car(Producer.HYUNDAI, "Solaris", CarClass.B, BodyType.SEDAN, TypeOfDrive.FULL, 4500, 2017, 190, 5.7));
        listCar.add(new Car(Producer.HYUNDAI, "Solaris", CarClass.B, BodyType.SEDAN, TypeOfDrive.FULL, 4500, 2017, 190, 5.7));
        listCar.add(new Car(Producer.KIA, "Rio", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 11000, 2017, 190, 3.8));
        listCar.add(new Car(Producer.SKODA, "Rapid", CarClass.C, BodyType.SEDAN, TypeOfDrive.FRONT, 12500, 2012, 190, 5.6));
        listCar.add(new Car(Producer.RENAULT, "Logan", CarClass.B, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2004, 175, 7.9));
        listCar.add(new Car(Producer.FORD, "Focus", CarClass.C, BodyType.SEDAN, TypeOfDrive.FRONT, 9200, 2011, 195, 8.3));
        listCar.add(new Car(Producer.TOYOTA, "Camry", CarClass.E, BodyType.SEDAN, TypeOfDrive.FULL, 18000, 2016, 210, 9.7));
        listCar.add(new Car(Producer.SKODA, "Octavia", CarClass.C, BodyType.HATCHBACK, TypeOfDrive.FULL, 35000, 2019, 230, 5));

        new Menu().start();
    }
}

class Menu {

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Создать таксопарк");
        System.out.println("2. Топ автомобилей");
        System.out.println("3. Отсортировать автомобили по расходу топлива");
        System.out.println("4. Поиск");
        System.out.println("5. Вывести все автомобили");
        System.out.println("6. Выход из приложения.");
    }

    private void printSearchMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По году выпуска авто");
        System.out.println("3. По производителю");
        System.out.println("4. По производителю и классу авто");
    }

    private void printTopMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По максимальной скорости");
    }


    public void start() throws IOException {
        TaxiPark taxiPark = new TaxiPark();
        Scanner scanner = new Scanner(System.in);
        if (scanner != null) {
            int key;
            do {
                printMainMenu();
                System.out.print("Введите номер меню: ");
                key = scanner.nextInt();
                switch (key) {
                    case 1:
                        System.out.println("Введите название файла!");
                        String select = scanner.next();
                        try {
                            ProductFileReadJSON productFileReadJSON = new ProductFileReadJSON();
                            taxiPark.addCar(productFileReadJSON.createLispProductFile(select));
                        } catch (Exception e) {
                            e.getStackTrace();
                            System.out.println("Ошибка! Данного файла не обнаружено!");
                        }
                        break;
                    case 2:
                        System.out.println("Выберите критерий!");
                        printTopMenu();
                        key = scanner.nextInt();
                        if (key == 1) taxiPark.topByPrice();
                        else if (key == 2) taxiPark.topByMaxSpeed();
                        else System.out.println("Вы ввели неверно значение меню");
                        break;
                    case 3:
                        taxiPark.sort();
                        break;
                    case 4:
                        System.out.println("Выберите критерий поиска!");
                        printSearchMenu();
                        key = scanner.nextInt();
                        if (key == 1) taxiPark.searchByPrice();
                        else if (key == 2) taxiPark.searchByYearOfManufacture();
                        else if (key == 3) taxiPark.searchByProduccer();
                        else if (key == 4) taxiPark.searchByTwoParameters();
                        else System.out.println("Вы ввели неверно значение меню");
                        break;
                    case 5:
                        System.out.println("Список всех автомобилей");
                        taxiPark.print();
                        break;
                    case 6:
                        System.out.println("Завершение программы...");
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }
            } while (key != 6);
        }
    }
}
