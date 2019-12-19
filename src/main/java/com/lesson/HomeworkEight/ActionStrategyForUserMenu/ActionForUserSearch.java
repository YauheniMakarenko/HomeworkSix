package com.lesson.HomeworkEight.ActionStrategyForUserMenu;

import com.lesson.HomeworkEight.Menu.AdminMenu;
import com.lesson.HomeworkEight.StrategySearch.AllSearchStrategies;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.Scanner;

public class ActionForUserSearch implements ActionStrategyForUser {

    private void printSearchMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По году выпуска авто");
        System.out.println("3. По производителю");
        System.out.println("4. По производителю и классу авто");
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        AllSearchStrategies allSearchStrategies = new AllSearchStrategies();
        System.out.println("Выберите критерий поиска!");
        printSearchMenu();
        int keyInt;
        String keyString = scanner.next();
        while (!new ValidatorForMenu().validate(keyString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        if (allSearchStrategies.getMap().containsKey(keyInt)){
            allSearchStrategies.getMap().get(keyInt).search();
        }
    }
}
