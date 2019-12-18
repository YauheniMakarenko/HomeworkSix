package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.ActionStrategyForUserMenu.ActionStrategyForUser;
import com.lesson.HomeworkEight.ActionStrategyForUserMenu.AllActionStrategyForUser;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.*;

public class UserMenu {
    private ActionStrategyForUser actionStrategyForUser;

    public static final int isExit = 5;

    private void printMainMenu() {
        System.out.println();
        System.out.println("1. Топ 5 автомобилей");
        System.out.println("2. Отсортировать автомобили по расходу топлива");
        System.out.println("3. Поиск");
        System.out.println("4. Вывести все автомобили");
        System.out.println("5. Выход из приложения");
    }

    private void action(ActionStrategyForUser actionStrategyForUser){
        this.actionStrategyForUser = actionStrategyForUser;
        actionStrategyForUser.action();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        AllActionStrategyForUser allActionStrategyForUser = new AllActionStrategyForUser();
        String keyString;
        int keyInt;
        try{
            do {
                printMainMenu();
                System.out.print("Введите номер меню: ");
                keyString = scanner.next();
                while (!new ValidatorForMenu().validate(keyString)){
                    System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
                    keyString = scanner.next();
                }
                keyInt = Integer.parseInt(keyString);
                if (allActionStrategyForUser.getMap().containsKey(keyInt)){
                    action(allActionStrategyForUser.getMap().get(keyInt));
                }
            } while (keyInt != isExit);
        }catch (NullPointerException e){
            e.getMessage();
            System.out.println("Таксопарка не существует!");
        }
    }
}
