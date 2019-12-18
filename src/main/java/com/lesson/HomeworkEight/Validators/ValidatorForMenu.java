package com.lesson.HomeworkEight.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorForMenu {

    private Pattern pattern;
    private Matcher matcher;


    private final String GIVEN_STRING = "\\d+";


    public boolean validate(String givenString){
        pattern = Pattern.compile(GIVEN_STRING);
        matcher = pattern.matcher(givenString);
        return matcher.matches();
    }
}
