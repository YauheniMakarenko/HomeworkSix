package com.lesson.HomeworkEight.Validators;

import java.util.Scanner;

public class ConsoleInputReader implements IConsoleInputReader {

    private Scanner scanner = new Scanner(System.in);
    private ValidatorForMenu validatorForMenu = new ValidatorForMenu();

    @Override
    public int checkTheMenuNumber(){
        String keyString = scanner.next();
        int keyInt;
        while (!validatorForMenu.validate(keyString)) {
            System.out.println("Вы ввели некорректное значение! Попробуйте снова используя цифры: ");
            keyString = scanner.next();
        }
        keyInt = Integer.parseInt(keyString);
        return keyInt;
    }

    @Override
    public String checkTheRole(){
        String role = scanner.next();
        while (!role.equals("admin") && !role.equals("user")){
            System.out.println("Введите корректно роль (admin/user)");
            role = scanner.next();
        }
        return role;
    }
}
