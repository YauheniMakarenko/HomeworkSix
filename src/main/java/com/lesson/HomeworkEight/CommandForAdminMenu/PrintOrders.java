package com.lesson.HomeworkEight.CommandForAdminMenu;

import com.lesson.HomeworkEight.TaxiPark;

public class PrintOrders implements CommandForAdmin {
    @Override
    public void action() {
        TaxiPark.getInstance().printOrders();
    }
}
