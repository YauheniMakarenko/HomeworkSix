package com.lesson.HomeworkEight.Menu;

import java.util.Scanner;

public class MainMenu {

    public void start(){
        System.out.println("Введите роль (admin/user): ");
        choiceRoll();
    }

    private void choiceRoll(){
        Scanner scanner = new Scanner(System.in);
        String role = scanner.next();
        while (!role.equals("admin") && !role.equals("user")){
            System.out.println("Введите корректно роль (admin/user)");
            role = scanner.next();
        }
        if (role.equals("admin")){
            System.out.println("Привет, admin!");
            new AdminMenu().adminStart();
        }
        else {
            System.out.println("Привет, user!");
            new UserMenu().start();
        }
        scanner.close();
    }
}
