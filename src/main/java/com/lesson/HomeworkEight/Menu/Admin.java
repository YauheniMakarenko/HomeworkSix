package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.ActionStrategyForAdminMenu.ActionStrategyForAdmin;
import com.lesson.HomeworkEight.ActionStrategyForAdminMenu.AllActionStrategyForAdmin;
import com.lesson.HomeworkEight.TaxiPark;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.Scanner;

public class Admin {
    private static TaxiPark taxiPark;
    private ActionStrategyForAdmin actionStrategyForAdmin;
    private static final int isExit = 5;

    public Admin(){
        this.taxiPark = new TaxiPark();
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Создать таксопарк");
        System.out.println("2. Вывести все автомобили");
        System.out.println("3. Вывести все заказы");
        System.out.println("4. Войти как user");
        System.out.println("5. Выход из приложения");
    }

    private void action(ActionStrategyForAdmin actionStrategyForAdmin){
        this.actionStrategyForAdmin = actionStrategyForAdmin;
        actionStrategyForAdmin.action();
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
            while (!new ValidatorForMenu().validate(keyString)){
                System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
                keyString = scanner.next();
            }
            keyInt = Integer.parseInt(keyString);
            if (allActionStrategyForAdmin.getMapAdmin().containsKey(keyInt)){
                action(allActionStrategyForAdmin.getMapAdmin().get(keyInt));
            }
        }while (keyInt != isExit);
        scanner.close();
    }

    public static TaxiPark getTaxiPark() {
        return taxiPark;
    }
}
