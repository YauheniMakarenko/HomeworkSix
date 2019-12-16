package com.lesson.HomeworkEight;

import com.lesson.HomeworkEight.File.ReadJSON;
import com.lesson.HomeworkEight.StrategySearch.SearchByPrice;
import com.lesson.HomeworkEight.StrategySearch.SearchByProduccer;
import com.lesson.HomeworkEight.StrategySearch.SearchByTwoParamerts;
import com.lesson.HomeworkEight.StrategySearch.SearchByYearOfManufacture;

import java.util.Scanner;

public class Menu {

    public static final int firstAction = 1;
    public static final int secondAction = 2;
    public static final int thirdAction = 3;
    public static final int fourthAction = 4;
    public static final int fifthAction = 5;
    public static final int isExit = 6;

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

    public void start() {
        TaxiPark taxiPark = new TaxiPark();
        Scanner scanner = new Scanner(System.in);
        int key;
        do {
            printMainMenu();
            System.out.print("Введите номер меню: ");
            key = scanner.nextInt();
            switch (key) {
                case firstAction:
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
                case secondAction:
                    System.out.println("Выберите критерий!");
                    printTopMenu();
                    key = scanner.nextInt();
                    if (key == firstAction) taxiPark.topByPrice();
                    else if (key == secondAction) taxiPark.topByMaxSpeed();
                    else System.out.println("Вы ввели неверно значение меню");
                    break;
                case thirdAction:
                    taxiPark.sort();
                    break;
                case fourthAction:
                    System.out.println("Выберите критерий поиска!");
                    printSearchMenu();
                    key = scanner.nextInt();
                    if (key == firstAction) taxiPark.search(new SearchByPrice());
                    else if (key == secondAction) taxiPark.search(new SearchByYearOfManufacture());
                    else if (key == thirdAction) taxiPark.search(new SearchByProduccer());
                    else if (key == fourthAction) taxiPark.search(new SearchByTwoParamerts());
                    else System.out.println("Вы ввели неверно значение меню");
                    break;
                case fifthAction:
                    System.out.println("Список всех автомобилей");
                    taxiPark.print();
                    break;
                case isExit:
                    System.out.println("Завершение программы...");
                    break;
                default:
                    System.out.println("Вы ввели неверное значение меню...\n");
            }
        } while (key != isExit);


    }
}
