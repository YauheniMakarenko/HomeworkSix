package com.lesson.HomeworkEight.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorForMenu {

    private final String GIVEN_STRING = "\\d+";

    private Pattern pattern = Pattern.compile(GIVEN_STRING);
    private Matcher matcher;

    public boolean validate(String givenString){
        matcher = pattern.matcher(givenString);
        return matcher.matches();
    }
}
