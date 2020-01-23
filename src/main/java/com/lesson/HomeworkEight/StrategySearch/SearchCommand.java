package com.lesson.HomeworkEight.StrategySearch;

import java.util.Arrays;

public enum SearchCommand {
    SEARCH_BY_PRICE(1, new SearchByPrice()),
    SEARCH_BY_YEAR_OF_MANUFACTURE(2, new SearchByYearOfManufacture()),
    SEARCH_BY_PRODUCCER(3, new SearchByProduccer()),
    SEARCH_BY_TWO_PARAMERTS(4, new SearchByTwoParamerts());


    private int code;
    private SearchStrategy command;

    SearchCommand(int code, SearchStrategy command) {
        this.code = code;
        this.command = command;
    }


    public static SearchStrategy findCommand(int numberCommand) {
        return Arrays.stream(SearchCommand.values())
                .filter(command -> command.code == numberCommand)
                .findAny()
                .get()
                .command;
    }
}
