package com.lesson.HomeworkEight.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorForFileName {
    private Pattern pattern;
    private Matcher matcher;


    private final String FILENAME_PATTERN = ".+\\.json";


    public boolean validate(String fileName){
        pattern = Pattern.compile(FILENAME_PATTERN);
        matcher = pattern.matcher(fileName);
        return matcher.matches();
    }
}
