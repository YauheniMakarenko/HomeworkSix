package com.lesson.HomeworkTen;

public class Reccursion {

    public int allNumber(int number) {
        if (number > 0) {
            allNumber(number - 1);
            System.out.print(number + " ");
        }
        return number;
    }

    public int sumOfDigits(int number) {
        if (number < 10) {
            return number%10;
        } else {
            return number%10 + sumOfDigits(number / 10);
        }
    }

    public boolean palindrome(String givenString) {
        if (givenString.length() <= 1) {
            return true;
        }
        if (givenString.charAt(0) == givenString.charAt(givenString.length()-1)){
            String s = givenString.substring(1, givenString.length()-1);
            return palindrome(s);
        }
        return false;
    }
}
