package com.lesson.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        wordsInLetter("t");
        sentencesFromTheWord();
        numberCheck();
        dateSearch();
        siteSearch();

    }

    public static void wordsInLetter(String givenString) {
        String s = "The money trouble is always at the top. " +
                "The role of money is rather big in people’s lives. " +
                "Having no money you can hardly live at all, because everything has its price. " +
                "A person has to eat, get dressed, and learn. " +
                "You need money for all of that. " +
                "You also need money so that you can travel and see the world and be independent.";

        Pattern pattern = Pattern.compile("\\b"+givenString + "\\w+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    public static void sentencesFromTheWord() {
        String s = "The money trouble is always at the top. " +
                "The role of money is rather big in people’s lives. Spring. " +
                "Having no money you can hardly live at all, because everything has its price. " +
                "A person has to eat, get dressed, and learn. Make; " +
                "You need money for all of that. " +
                "You also need money so that you can travel and see the world and be independent.";

        Pattern pattern = Pattern.compile("[A-Z]\\w+(\\.|;|:)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    public static void numberCheck() {
        String[] s = {"+375291233214", "375331233212", "+375(25)4321232", "+375(29) 123-32-12", "+375(29) 123 32 13"};

        Pattern pattern = Pattern.compile("\\+?375\\(?(29|33|25)\\)?.+");
        for (int i = 0; i < s.length; i++) {
            Matcher matcher = pattern.matcher(s[i]);
            if (matcher.find()) {
                String group = matcher.group();
                System.out.println(group);
            }
        }
    }

    public static void dateSearch() {
        String s = "The money trouble is always at the top. " +
                "The role of money is rather big in people’s lives. 2019.12.14 17:34. Spring. " +
                "Having no money you can hardly live at all, because everything has its price. " +
                "A person has to eat, get dressed, and learn. Make; " +
                "You need money for all of that. 2019.12.14 17:34. " +
                "You also need money so that you can travel and see the world and be independent.";

        Pattern pattern = Pattern.compile("\\d{4}\\.\\d{2}\\.\\d{2} \\d{2}:\\d{2}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    public static void siteSearch() {
        String s = "The money trouble is always at the top. google.com. " +
                "The role of money is rather big in people’s lives. 2019.12.14 17:34. Spring. " +
                "Having no money you can hardly live at all, because everything has its price. www.yandex.ru." +
                "A person has to eat, get dressed, and learn. Make; " +
                "You need money for all of that. 2019.12.14 17:34. " +
                "You also need money so that you can travel and see the world and be independent.";

        Pattern pattern = Pattern.compile("(www)?\\.?\\w+?\\.(ru|by|com)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
