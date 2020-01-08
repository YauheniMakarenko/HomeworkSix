package com.lesson.HomeworkEight.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorForFileName {

    private final String FILENAME_PATTERN = ".+\\.json";

    private Pattern pattern = Pattern.compile(FILENAME_PATTERN);
    private Matcher matcher;

    public boolean validate(String fileName){
        matcher = pattern.matcher(fileName);
        return matcher.matches();
    }
}
