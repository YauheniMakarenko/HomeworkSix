package com.lesson.HomeworkEight.SortStrategy;

import java.util.Arrays;

public enum SortCommand {

    SORT_TOP_BY_PRICE(1, new SortTopByPrice()),
    SORT_TOP_BY_MAX_SPEED(2, new SortTopByMaxSpeed());

    private int code;
    private SortStrategy command;

    SortCommand(int code, SortStrategy command) {
        this.code = code;
        this.command = command;
    }


    public static SortStrategy findCommand(int numberCommand) {
        return Arrays.stream(SortCommand.values())
                .filter(command -> command.code == numberCommand)
                .findAny()
                .get()
                .command;
    }
}
