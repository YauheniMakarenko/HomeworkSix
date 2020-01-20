package com.lesson.HomeworkEight.CommandForAdminMenu;

import java.util.Arrays;

public enum Remote_Control_Admin {

    CREATE_TAXI_PARK(1, new CreateTaxiPark()),
    ADD_CAR_IN_TAXI_PARK(2, new AddCarInTaxoPark()),
    PRINT_CAR(3, new PrintCar()),
    PRINT_ORDER(4, new PrintOrders()),
    LOG_IN_USER(5, new LogInUser()),
    IS_Exit(6, new IsExit());

    private int code;
    private CommandForAdmin command;

    Remote_Control_Admin(int code, CommandForAdmin command) {
        this.code = code;
        this.command = command;
    }


    public static CommandForAdmin findCommand(int numberCommand) {
        return Arrays.stream(Remote_Control_Admin.values())
                .filter(command -> command.code == numberCommand)
                .findAny()
                .get()
                .command;
    }
}
