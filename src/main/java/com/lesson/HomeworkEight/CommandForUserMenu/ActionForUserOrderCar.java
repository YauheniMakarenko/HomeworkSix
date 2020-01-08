package com.lesson.HomeworkEight.CommandForUserMenu;

import com.lesson.HomeworkEight.Menu.AdminMenu;
import com.lesson.HomeworkEight.TaxiPark;

public class ActionForUserOrderCar implements CommandsForUser {
    @Override
    public void action() {
        TaxiPark.createSingletonTaxiPark().addClient();
    }
}
