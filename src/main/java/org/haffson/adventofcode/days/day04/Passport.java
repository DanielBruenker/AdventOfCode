package org.haffson.adventofcode.days.day04;

import java.util.*;


public class Passport {

    private final Map<String, String> fields;

    public Passport(Map<String, String> fields) {
        this.fields = fields;
    }

    /***
     * This class method can use to create a Passport object from a string.
     *
     * @param passport
     * @return a new Passport object
     */
    public static Passport fromString(String passport) {
        Map<String, String> fields = new HashMap<String, String>();
        String[] parts = passport.split("[\\s]");
        for (String part : parts) {
            String fieldName = part.substring(0, 3);
            String value = part.substring(4);
            fields.put(fieldName, value);
        }
        return new Passport(fields);
    }

    public boolean hasField(String fieldName) {
        return fields.containsKey(fieldName);
    }

    public String getFieldValue(String fieldName) {
        return fields.get(fieldName);
    }

}
