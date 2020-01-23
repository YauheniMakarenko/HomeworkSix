package com.lesson.HomeworkEight.StrategySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface SearchStrategy {
    void search();

    default String readValue() {
        String string = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;

    }
}
