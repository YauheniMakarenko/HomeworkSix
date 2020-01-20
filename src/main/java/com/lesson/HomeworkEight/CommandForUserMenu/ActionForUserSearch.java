package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.StrategySearch.SearchCommand;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ActionForUserSearch implements CommandForUser {

    private void printSearchMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По году выпуска авто");
        System.out.println("3. По производителю");
        System.out.println("4. По производителю и классу авто");
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерий поиска!");
        printSearchMenu();
        int keyInt;
        String keyString = scanner.next();
        while (!new ValidatorForMenu().validate(keyString)) {
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        try {
            SearchCommand.findCommand(keyInt).search();
        } catch (NoSuchElementException e) {
            System.out.println("Вы ввели некорректный пункт меню");
        }
    }
}
