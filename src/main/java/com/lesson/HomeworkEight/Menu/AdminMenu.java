package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.ActionStrategyForAdminMenu.AllActionStrategyForAdmin;
import com.lesson.HomeworkEight.TaxiPark;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.Scanner;

public class AdminMenu {
    private static TaxiPark taxiPark = new TaxiPark();
    private final int isExit = 6;
    ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Создать таксопарк");
        System.out.println("2. Добавить машину в таксопарк");
        System.out.println("3. Вывести все автомобили");
        System.out.println("4. Вывести все заказы");
        System.out.println("5. Войти как user");
        System.out.println("6. Выход из приложения");
    }

    public void adminStart(){
        Scanner scanner = new Scanner(System.in);
        AllActionStrategyForAdmin allActionStrategyForAdmin = new AllActionStrategyForAdmin();
        String keyString;
        int keyInt;
        do {
            printMainMenu();
            System.out.print("Введите номер меню: ");
            keyString = scanner.next();
            while (!validatorForMenu.validate(keyString)){
                System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
                keyString = scanner.next();
            }
            keyInt = Integer.parseInt(keyString);
            if (allActionStrategyForAdmin.getMapAdmin().containsKey(keyInt)){
                allActionStrategyForAdmin.getMapAdmin().get(keyInt).action();
            }
        }while (keyInt != isExit);
        scanner.close();
    }

    public static TaxiPark getTaxiPark() {
        return taxiPark;
    }
}
