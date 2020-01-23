package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.CommandForUserMenu.RemoteControlUser;
import com.lesson.HomeworkEight.Validators.ConsoleInputReader;

import java.util.*;

public class UserMenu {

    private ConsoleInputReader consoleInputReader = new ConsoleInputReader();

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
        int keyInt;
        try {
            do {
                printMainMenu();
                System.out.print("Введите номер меню: ");
                keyInt = consoleInputReader.checkTheMenuNumber();
                try {
                    RemoteControlUser.findCommand(keyInt).action();
                } catch (NoSuchElementException e) {
                    System.out.println("Вы ввели некорректный пункт меню");
                }
            } while (keyInt != isExit);
        } catch (NullPointerException e) {
            e.getMessage();
            System.out.println("Таксопарка не существует!");
        }
    }
}
