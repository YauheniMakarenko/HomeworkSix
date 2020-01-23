package com.lesson.HomeworkEight.Validators;

import java.util.Scanner;

public class Check {

    private Scanner scanner;
    private ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    public int checkTheMenuNumber(){
        scanner = new Scanner(System.in);
        String keyString = scanner.next();
        int keyInt;
        while (!validatorForMenu.validate(keyString)) {
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        return keyInt;
    }
}
