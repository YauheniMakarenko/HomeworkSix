package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.File.ReadJSON;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
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
                            ReadJSON productFileReadJSON = new ReadJSON();
                            taxiPark.addCar(productFileReadJSON.createLispProductFile(select));
                        } catch (Exception e) {
                            e.getStackTrace();
                            System.out.println("Ошибка! Данного файла не обнаружено!");
                            System.out.println("Данные загружены из Main");
                            Main main = new Main();
                            taxiPark.addCar(main.add());
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
