package com.lesson.HomeworkEight.ActionStrategyForAdminMenu;

import com.lesson.HomeworkEight.File.ReadJSON;
import com.lesson.HomeworkEight.Main;
import com.lesson.HomeworkEight.Menu.Admin;
import com.lesson.HomeworkEight.Validators.ValidatorForFileName;

import java.util.Scanner;

public class FirstActionForAdmin implements ActionStrategyForAdmin {

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла!");
        String select = scanner.next();
        while (!new ValidatorForFileName().validate(select)) {
            System.out.println("Имя файла некорректное, пожалуйста, введите имя файла например: \"car.json\": ");
            select = scanner.next();
        }
        try {
            ReadJSON productFileReadJSON = new ReadJSON();
            Admin.getTaxiPark().addCar(productFileReadJSON.createLispProductFile(select));
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Ошибка! Данного файла не обнаружено!");
            System.out.println("Данные загружены из Main");
            Main main = new Main();
            Admin.getTaxiPark().addCar(main.add());
        }
    }
}
