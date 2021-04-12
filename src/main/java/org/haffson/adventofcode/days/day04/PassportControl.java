package org.haffson.adventofcode.days.day04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/***
 * This class provides functions to check if a passport is valid.
*/
public class PassportControl {

    /***
     * This function can use to check if a passport is valid.
     *
     * @param passport passport string
     * @return true if the passport valid else false
     */
    public static boolean controlPassport(String passport) {
        boolean byr = checkBirthYear(passport);
        boolean iyr = checkIssueYear(passport);
        boolean eyr = checkExpirationYear(passport);
        boolean hgt = checkHeight(passport);
        boolean hcl = checkHairColor(passport);
        boolean ecl = checkEyeColor(passport);
        boolean pid = checkPassportID(passport);

        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }


    /***
     * Tis function can use to check if the "Birth Year" field is valid.
     *
     * @param passport passport as string
     * @return true if "Birth Year" exists and is valid, else false
     */
    static boolean checkBirthYear(String passport){
        // (Birth Year) - four digits; at least 1920 and at most 2002
        String condition =  "19[2-9][0-9]|200[0-2]";
        return checkPassportField("byr", condition, passport);
    }

    /***
     * Tis function can use to check if the "Issue Year" field is valid.
     *
     * @param passport passport as string
     * @return true if "Issue Year" exists and is valid, else false
     */
    static boolean checkIssueYear(String passport){
        // (Issue Year) - four digits; at least 2010 and at most 2020
        String condition = "(201[1-9]|2020)";
        return checkPassportField("iyr", condition, passport);
    }

    /***
     * Tis function can use to check if the "Expiration Year" field is valid.
     *
     * @param passport passport as string
     * @return true if "Expiration Year" exists and is valid, else false
     */
    static boolean checkExpirationYear(String passport){
        // (Expiration Year) - four digits; at least 2020 and at most 2030.
        String condition = "(202[0-9]|2030)";
        return checkPassportField("eyr", condition, passport);
    }

    /***
     * Tis function can use to check if the "Height" field is valid.
     *
     * @param passport passport as string
     * @return true if "Height" exists and is valid, else false
     */
    static boolean checkHeight(String passport){
        // (Height) - a number followed by either cm or in:
        //      - If cm, the number must be at least 150 and at most 193
        //      - If in, the number must be at least 59 and at most 76
        String condition = "(1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in)";
        return checkPassportField("hgt", condition, passport);
    }

    /***
     * Tis function can use to check if the "Hair Color" field is valid.
     *
     * @param passport passport as string
     * @return true if "Hair Color" exists and is valid, else false
     */
    static boolean checkHairColor(String passport){
        // (Hair Color) - a # followed by exactly  0-9 or a-f.
        String condition = "(#[a-f0-9]{6})";
        return checkPassportField("hcl", condition, passport);
    }


    /***
     * Tis function can use to check if the "Eye Color" field is valid.
     *
     * @param passport passport as string
     * @return true if "Eye Color" exists and is valid, else false
     */
    static boolean checkEyeColor(String passport){
        // (Eye Color) - a # followed by exactly  0-9 or a-f.
        String condition = "(amb|blu|brn|gry|grn|hzl|oth)";
        return checkPassportField("ecl", condition, passport);
    }

    /***
     * Tis function can use to check if the "Passport ID" field is valid.
     *
     * @param passport passport as string
     * @return true if "Passport ID" exists and is valid, else false
     */
    static boolean checkPassportID(String passport){
        // (Passport ID) - a nine-digit number, including leading zeroes
        String condition = "([0-9]{9})";
        return checkPassportField("pid", condition, passport);
    }


    /***
     *  This function can be used to check if the passport has the field you are looking for and if
     *  the value matches the conditions.
     *  @param fieldName name of the field
     *  @param condition regex expression to check the value of the field
     *  @param passport passport
     *  @return true if the field exist and the value is valid, else false
     */
    static boolean checkPassportField(String fieldName, String condition, String passport){
        String regex = fieldName +  "[:]" + condition;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passport);
        return matcher.find();
    }






}
