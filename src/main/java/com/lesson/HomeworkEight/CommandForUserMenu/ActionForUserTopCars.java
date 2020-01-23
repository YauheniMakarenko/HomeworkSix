package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.Car;
import com.lesson.HomeworkEight.SortStrategy.SortCommand;
import com.lesson.HomeworkEight.Validators.ConsoleInputReader;
import com.lesson.HomeworkEight.Validators.IConsoleInputReader;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ActionForUserTopCars implements CommandForUser {

    private IConsoleInputReader consoleInputReader = new ConsoleInputReader();

    private void printTopMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По максимальной скорости");
    }

    @Override
    public void action() {
        System.out.println("Выберите критерий!");
        printTopMenu();
        int keyInt = consoleInputReader.checkTheMenuNumber();
        try {
            List<Map.Entry<Car, Integer>> list = SortCommand.findCommand(keyInt).sortTop();
            System.out.println("Введите количество машин для вывода");
            int key = consoleInputReader.checkTheMenuNumber();
            if (key > list.size()) {
                key = list.size();
            }
            for (int i = 0; i < key; i++) {
                System.out.println(list.get(i));
            }
        } catch (NoSuchElementException e) {
            System.out.println("Вы ввели некорректный пункт меню");
        }
    }
    
}
