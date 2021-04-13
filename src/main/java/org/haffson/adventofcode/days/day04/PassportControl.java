package org.haffson.adventofcode.days.day04;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * This class provides functions to check if a passport is valid.
 */
public class PassportControl {

    public static final List<String> REQUIRED_FIELDS = Arrays.asList(
            "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"
    );


    /***
     * This function can use to check if a passport is valid.
     *
     * @param passport passport string
     * @param checkValues check also the field values
     * @return true if the passport valid else false
     */
    public static boolean controlPassport(Passport passport, boolean checkValues) {
        boolean isValid = true;
        for (String fieldName : REQUIRED_FIELDS) {
            isValid = isValid && passport.hasField(fieldName);
            if (checkValues) {
                switch (fieldName) {
                    case "byr":
                        isValid = isValid && checkBirthYear(passport.getFieldValue(fieldName));
                        break;
                    case "iyr":
                        isValid = isValid && checkIssueYear(passport.getFieldValue(fieldName));
                        break;
                    case "eyr":
                        isValid = isValid && checkExpirationYear(passport.getFieldValue(fieldName));
                        break;
                    case "hgt":
                        isValid = isValid && checkHeight(passport.getFieldValue(fieldName));
                        break;
                    case "hcl":
                        isValid = isValid && checkHairColor(passport.getFieldValue(fieldName));
                        break;
                    case "ecl":
                        isValid = isValid && checkEyeColor(passport.getFieldValue(fieldName));
                        break;
                    case "pid":
                        isValid = isValid && checkPassportID(passport.getFieldValue(fieldName));
                        break;
                }
            }
        }
        return isValid;
    }


    /***
     * Tis function can use to check if the "Birth Year" field is valid.
     *
     * @param birthYear birth year as string
     * @return true if "Birth Year" exists and is valid, else false
     */
    static boolean checkBirthYear(String birthYear) {
        // (Birth Year) - four digits; at least 1920 and at most 2002
        String condition = "19[2-9][0-9]|200[0-2]";
        return checkPassportFieldValue(condition, birthYear);
    }

    /***
     * Tis function can use to check if the "Issue Year" field is valid.
     *
     * @param issueYear issue year as string
     * @return true if "Issue Year" exists and is valid, else false
     */
    static boolean checkIssueYear(String issueYear) {
        // (Issue Year) - four digits; at least 2010 and at most 2020
        String condition = "201[0-9]|2020";
        return checkPassportFieldValue(condition, issueYear);
    }

    /***
     * Tis function can use to check if the "Expiration Year" field is valid.
     *
     * @param expirationYear expiration year as string
     * @return true if "Expiration Year" exists and is valid, else false
     */
    static boolean checkExpirationYear(String expirationYear) {
        // (Expiration Year) - four digits; at least 2020 and at most 2030.
        String condition = "202[0-9]|2030";
        return checkPassportFieldValue(condition, expirationYear);
    }

    /***
     * Tis function can use to check if the "Height" field is valid.
     *
     * @param height height as string
     * @return true if "Height" exists and is valid, else false
     */
    static boolean checkHeight(String height) {
        // (Height) - a number followed by either cm or in:
        //      - If cm, the number must be at least 150 and at most 193
        //      - If in, the number must be at least 59 and at most 76
        String condition = "1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in";
        return checkPassportFieldValue(condition, height);
    }

    /***
     * Tis function can use to check if the "Hair Color" field is valid.
     *
     * @param hairColor hair color as string
     * @return true if "Hair Color" exists and is valid, else false
     */
    static boolean checkHairColor(String hairColor) {
        // (Hair Color) - a # followed by exactly  0-9 or a-f.
        String condition = "#[a-f0-9]{6}";
        return checkPassportFieldValue(condition, hairColor);
    }

    /***
     * Tis function can use to check if the "Eye Color" field is valid.
     *
     * @param eyeColor eye color as string
     * @return true if "Eye Color" exists and is valid, else false
     */
    static boolean checkEyeColor(String eyeColor) {
        // (Eye Color) - a # followed by exactly  0-9 or a-f.
        String condition = "amb|blu|brn|gry|grn|hzl|oth";
        return checkPassportFieldValue(condition, eyeColor);
    }

    /***
     * Tis function can use to check if the "Passport ID" field is valid.
     *
     * @param passwordID passwordID
     * @return true if "Passport ID" exists and is valid, else false
     */
    static boolean checkPassportID(String passwordID) {
        // (Passport ID) - a nine-digit number, including leading zeroes
        String condition = "[0-9]{9}";
        return checkPassportFieldValue(condition, passwordID);
    }

    /***
     *  This function can be used to check if the passport has the field you are looking for and if
     *  the value matches the conditions.
     *  @param regex regex expression to check the value of the field
     *  @param value value
     *  @return true if the value is valid, else false
     */
    static boolean checkPassportFieldValue(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

}
