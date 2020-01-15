package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.CommandForAdminMenu.RemoteControlAdmin;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.Scanner;

public class AdminMenu {

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
        RemoteControlAdmin remoteControlAdmin = new RemoteControlAdmin();
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
            if (remoteControlAdmin.getMapAdmin().containsKey(keyInt)){
                remoteControlAdmin.getMapAdmin().get(keyInt).action();
            }
        }while (keyInt != isExit);
        scanner.close();
    }

}
