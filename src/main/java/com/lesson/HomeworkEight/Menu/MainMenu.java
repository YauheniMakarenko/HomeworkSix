package com.lesson.HomeworkEight.Menu;

import com.lesson.HomeworkEight.File.ReadJSON;
import com.lesson.HomeworkEight.TaxiPark.TaxiPark;
import com.lesson.HomeworkEight.Validators.ConsoleInputReader;
import com.lesson.HomeworkSeven.Check;

import java.util.Scanner;

public class MainMenu {

    private ConsoleInputReader consoleInputReader = new ConsoleInputReader();

    public void start(){
        /*ReadJSON productFileReadJSON = new ReadJSON();
        TaxiPark.getInstance().addCar(productFileReadJSON.createLispProductFile("listCar.json"));*/
        System.out.println("Введите роль (admin/user): ");
        choiceRoll();
    }

    private void choiceRoll(){
        String role = consoleInputReader.checkTheRole();
        if (role.equals("admin")){
            System.out.println("Привет, admin!");
            new AdminMenu().adminStart();
        }
        else {
            System.out.println("Привет, user!");
            new UserMenu().start();
        }
    }
}
