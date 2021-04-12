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
    public static List<String> parsePassports(List<String> rawPassports) {
        List<String> passports = new ArrayList<>();
        StringBuilder passport = null;

        for (String line : rawPassports) {
            if (line.isEmpty()) {
                passports.add(passport.toString());
                passport = null;
            } else {
                if (passport != null) {
                    passport.append(" ").append(line);
                } else {
                    passport = new StringBuilder();
                    passport.append(line);
                }
            }
        }
        passports.add(passport.toString());

        return passports;
    }

}
