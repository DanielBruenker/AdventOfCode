package org.haffson.adventofcode.days.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordPoliceParser {

    private final static String POLICE_REGEX = "(0?[1-9]|[1-9][0-9])[-](0?[1-9]|[1-9][0-9])[\\s]([a-z])";
    private final static String PASSWORD_REGEX = "([:][\\s])(\\w+)";

    /***
     * This function can use to parse the police part from the police and password string.
     *
     * @param policeAndPassword the password with police string.
     * @return returns the police.
     */
    static String parsePolice(String policeAndPassword) {
        Pattern pattern = Pattern.compile(POLICE_REGEX);
        Matcher matcher = pattern.matcher(policeAndPassword);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }

    /***
     * This function can use to parse the password part from the police and password string.
     *
     * @param policeAndPassword the password with police string.
     * @return returns the password.
     */
    static String parsePassword(String policeAndPassword) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(policeAndPassword);
        if (matcher.find()) {
            return matcher.group(2);
        } else {
            return null;
        }
    }

    static int parseFirstPoliceCondition(String police) {
        Pattern pattern = Pattern.compile(POLICE_REGEX);
        Matcher matcher = pattern.matcher(police);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return -1;
        }
    }

    static int parseSecondPoliceCondition(String police) {
        Pattern pattern = Pattern.compile(POLICE_REGEX);
        Matcher matcher = pattern.matcher(police);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(2));
        } else {
            return -1;
        }
    }

    static char parseCharacter(String police) {
        Pattern pattern = Pattern.compile(POLICE_REGEX);
        Matcher matcher = pattern.matcher(police);
        if (matcher.find()) {
            return matcher.group(3).charAt(0);
        } else {
            return '\u0000';
        }
    }
}
