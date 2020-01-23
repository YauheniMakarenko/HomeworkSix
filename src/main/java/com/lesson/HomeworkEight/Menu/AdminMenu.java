package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.CommandForAdminMenu.RemoteControlAdmin;
import com.lesson.HomeworkEight.Validators.ConsoleInputReader;

import java.util.NoSuchElementException;

public class AdminMenu {

    private final int isExit = 6;
    private ConsoleInputReader consoleInputReader = new ConsoleInputReader();

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Создать таксопарк");
        System.out.println("2. Добавить машину в таксопарк");
        System.out.println("3. Вывести все автомобили");
        System.out.println("4. Вывести все заказы");
        System.out.println("5. Войти как user");
        System.out.println("6. Выход из приложения");
    }

    public void adminStart() {
        int keyInt;
        do {
            printMainMenu();
            System.out.print("Введите номер меню: ");
            keyInt = consoleInputReader.checkTheMenuNumber();
            try {
                RemoteControlAdmin.findCommand(keyInt).action();
            } catch (NoSuchElementException e) {
                System.out.println("Вы ввели некорректный пункт меню");
            }
        } while (keyInt != isExit);
    }

}
