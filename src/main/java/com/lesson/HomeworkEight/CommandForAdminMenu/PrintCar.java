package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.TaxiPark.TaxiPark;

public class PrintCar implements CommandForAdmin {

    @Override
    public void action() {
        TaxiPark.getInstance().printCar();
    }
}
