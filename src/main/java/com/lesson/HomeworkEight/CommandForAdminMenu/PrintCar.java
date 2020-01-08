package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.Menu.AdminMenu;
import com.lesson.HomeworkEight.TaxiPark;

public class PrintCar implements CommandsForAdmin {

    @Override
    public void action() {
        TaxiPark.createSingletonTaxiPark().printCar();
    }
}
