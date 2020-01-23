package com.lesson.HomeworkEight.CommandForUserMenu;

import java.util.Arrays;

public enum RemoteControlUser {
    TOP_CARS(1, new ActionForUserTopCars()),
    SORT_CARS(2, new ActionForUserSortFullСonsumption()),
    SEARCH(3, new ActionForUserSearch()),
    ORDER_CAR(4, new ActionForUserOrderCar()),
    IS_EXIT(5, new IsExitActionForUser());


    private int code;
    private CommandForUser command;

    RemoteControlUser(int code, CommandForUser command) {
        this.code = code;
        this.command = command;
    }


    public static CommandForUser findCommand(int numberCommand) {
        return Arrays.stream(RemoteControlUser.values())
                .filter(command -> command.code == numberCommand)
                .findAny()
                .get()
                .command;
    }
}
