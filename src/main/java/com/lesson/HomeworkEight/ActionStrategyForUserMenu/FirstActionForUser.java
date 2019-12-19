package com.lesson.HomeworkEight.ActionStrategyForUserMenu;

import com.lesson.HomeworkEight.Menu.Admin;
import com.lesson.HomeworkEight.SortStrategy.AllSortStrategy;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.Scanner;

public class FirstActionForUser implements ActionStrategyForUser {

    private void printTopMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По максимальной скорости");
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        AllSortStrategy allSortStrategy = new AllSortStrategy();
        System.out.println("Выберите критерий!");
        printTopMenu();
        int keyInt;
        String keyString = scanner.next();
        while (!new ValidatorForMenu().validate(keyString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        try{
            if (allSortStrategy.getMapSort().containsKey(keyInt)){
                Admin.getTaxiPark().topBy(allSortStrategy.getMapSort().get(keyInt));
            }
        }catch (IndexOutOfBoundsException e){
            e.getMessage();
            System.out.println("Такспопарк не создан!");
        }
    }
}
