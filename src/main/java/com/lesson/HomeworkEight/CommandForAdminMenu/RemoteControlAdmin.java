package com.lesson.HomeworkEight.CommandForAdminMenu;

import java.util.Arrays;

public enum RemoteControlAdmin {

    CREATE_TAXI_PARK(1, new CreateTaxiPark()),
    ADD_CAR_IN_TAXI_PARK(2, new AddCarInTaxoPark()),
    PRINT_CAR(3, new PrintCar()),
    PRINT_ORDER(4, new PrintOrders()),
    LOG_IN_USER(5, new LogInUser()),
    IS_EXIT(6, new IsExit());

    private int code;
    private CommandForAdmin command;

    RemoteControlAdmin(int code, CommandForAdmin command) {
        this.code = code;
        this.command = command;
    }


    public static CommandForAdmin findCommand(int numberCommand) {
        return Arrays.stream(RemoteControlAdmin.values())
                .filter(command -> command.code == numberCommand)
                .findAny()
                .get()
                .command;
    }
}
