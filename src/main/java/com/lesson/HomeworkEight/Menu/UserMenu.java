package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.CommandForUserMenu.AllCommandsForUser;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;

public class UserMenu {
    ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    public final int isExit = 5;

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Топ 5 автомобилей");
        System.out.println("2. Отсортировать автомобили по расходу топлива");
        System.out.println("3. Поиск");
        System.out.println("4. Сделать заказ");
        System.out.println("5. Выход из приложения");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        AllCommandsForUser allCommandsForUser = new AllCommandsForUser();
        String keyString;
        int keyInt;
        try {
            do {
                printMainMenu();
                System.out.print("Введите номер меню: ");
                keyString = scanner.next();
                while (!validatorForMenu.validate(keyString)) {
                    System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
                    keyString = scanner.next();
                }
                keyInt = Integer.parseInt(keyString);
                if (allCommandsForUser.getMap().containsKey(keyInt)) {
                    allCommandsForUser.getMap().get(keyInt).action();
                }
            } while (keyInt != isExit);
        } catch (NullPointerException e) {
            e.getMessage();
            System.out.println("Таксопарка не существует!");
        }
    }
}
