package com.lesson.HomeworkEight.CommandForUserMenu;

import java.util.Arrays;

public enum Remote_Control_User {
    TOP_CARS(1, new ActionForUserTopCars()),
    SORT_CARS(2, new ActionForUserSortFullСonsumption()),
    SEARCH(3, new ActionForUserSearch()),
    ORDER_CAR(4, new ActionForUserOrderCar()),
    IS_Exit(5, new IsExitActionForUser());


    private int code;
    private CommandForUser command;

    Remote_Control_User(int code, CommandForUser command) {
        this.code = code;
        this.command = command;
    }


    public static CommandForUser findCommand(int numberCommand) {
        return Arrays.stream(Remote_Control_User.values())
                .filter(command -> command.code == numberCommand)
                .findAny()
                .get()
                .command;
    }
}
