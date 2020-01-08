package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.SortStrategy.AllSortStrategy;
import com.lesson.HomeworkEight.Validators.ValidatorForMenu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ActionForUserTopCars implements CommandForUser {

    private ValidatorForMenu validatorForMenu = new ValidatorForMenu();

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
        while (!validatorForMenu.validate(keyString)){
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        try{
            if (allSortStrategy.getMapSort().containsKey(keyInt)){
                List<Map.Entry<Car, Integer>> list = allSortStrategy.getMapSort().get(keyInt).sortTop();
                System.out.println("Введите количество машин для вывода");
                String keyStringCom = scanner.next();
                while (!validatorForMenu.validate(keyStringCom)){
                    System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
                    System.out.println("Введите количество машин для вывода: ");
                    keyStringCom = scanner.next();
                }
                int key = Integer.parseInt(keyStringCom);
                if (key > list.size()){
                    key = list.size();
                }
                for (int i = 0; i < key; i++) {
                    System.out.println(list.get(i));
                }
            }
        }catch (IndexOutOfBoundsException e){
            e.getMessage();
            System.out.println("Такспопарк не создан!");
        }
    }
}
