package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.StrategySearch.SearchCommand;
import com.lesson.HomeworkEight.Validators.ConsoleInputReader;
import com.lesson.HomeworkEight.Validators.IConsoleInputReader;

import java.util.NoSuchElementException;

public class ActionForUserSearch implements CommandForUser {

    private IConsoleInputReader consoleInputReader = new ConsoleInputReader();

    private void printSearchMenu() {
        System.out.println("1. По цене");
        System.out.println("2. По году выпуска авто");
        System.out.println("3. По производителю");
        System.out.println("4. По производителю и классу авто");
    }

    @Override
    public void action() {
        System.out.println("Выберите критерий поиска!");
        printSearchMenu();
        int keyInt = consoleInputReader.checkTheMenuNumber();
        try {
            SearchCommand.findCommand(keyInt).search();
        } catch (NoSuchElementException e) {
            System.out.println("Вы ввели некорректный пункт меню");
        }
    }
}
