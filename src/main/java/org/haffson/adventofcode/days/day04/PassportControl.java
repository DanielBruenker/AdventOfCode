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
        // Check passport has "Birth Year" field
        boolean byr = checkPassportHasField("byr", passport);
        // Check passport has "Issue Year" field
        boolean iyr = checkPassportHasField("iyr", passport);
        // Check passport has "Expiration Year" field
        boolean eyr = checkPassportHasField("eyr", passport);
        // Check passport has "Height" field
        boolean hgt = checkPassportHasField("hgt", passport);
        // Check passport has "Hair Color" field
        boolean hcl = checkPassportHasField("hcl", passport);
        // Check passport has "Eye Color" field
        boolean ecl = checkPassportHasField("ecl", passport);
        // Check passport has "Passport ID" field
        boolean pid = checkPassportHasField("pid", passport);

        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }

    /***
     * This function can use to check if the passport has the searched field.
     *
     * @param fieldName
     * @param passport
     * @return true if the field exist else false
     */
    static boolean checkPassportHasField(String fieldName, String passport) {
        String regex = fieldName + "[:]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passport);
        return matcher.find();
    }

}
