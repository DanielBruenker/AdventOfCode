package org.haffson.adventofcode.days.day04;

import java.util.ArrayList;
import java.util.List;


/***
 * This class is used in Day04 of Advent of Code to parse raw passports.
 */
public class PassportParser {

    /***
     * This function can use to convert the passport list into a more manageable list,
     * without empty entries and where each passport consists of only one entry.
     *
     * @param rawPassports raw passports
     * @return the parsed passports as List
     */
    public static List<Passport> parsePassports(List<String> rawPassports) {
        List<Passport> passports = new ArrayList<>();
        StringBuilder stringBuilder = null;

        for (String line : rawPassports) {
            if (line.isEmpty()) {
                Passport passport = Passport.fromString(stringBuilder.toString());
                passports.add(passport);
                stringBuilder = null;
            } else {
                if (stringBuilder != null) {
                    stringBuilder.append(" ").append(line);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(line);
                }
            }
        }
        Passport passport = Passport.fromString(stringBuilder.toString());
        passports.add(passport);

        return passports;
    }


}
