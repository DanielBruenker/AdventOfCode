package org.haffson.adventofcode.days.day02;

import org.springframework.util.StringUtils;

public class PasswordPoliceFirstPart implements IPasswordPolice {

    private final int minOccurrence;
    private final int macOccurrence;
    private final char character;

    public PasswordPoliceFirstPart(int minOccurrence, int macOccurrence, char character) {
        this.minOccurrence = minOccurrence;
        this.macOccurrence = macOccurrence;
        this.character = character;
    }

    static PasswordPoliceFirstPart fromPoliceAndPasswordString(String policeAndPassword) {
        String policeString = PasswordPoliceParser.parsePolice(policeAndPassword);
        char character = PasswordPoliceParser.parseCharacter(policeString);
        int minOccurrence = PasswordPoliceParser.parseFirstPoliceCondition(policeString);
        int maxOccurrence = PasswordPoliceParser.parseSecondPoliceCondition(policeString);
        return new PasswordPoliceFirstPart(minOccurrence, maxOccurrence, character);
    }

    public int getMinOccurrence() {
        return minOccurrence;
    }

    public int getMacOccurrence() {
        return macOccurrence;
    }

    public char getCharacter() {
        return character;
    }

    /***
     * This function can use to validate a password.
     * @param password password as string
     * @return returns true if the password valid.
     */
    @Override
    public boolean validatePassword(String password) {
        int occurrence = StringUtils.countOccurrencesOf(password, character + "");
        return minOccurrence <= occurrence && occurrence <= macOccurrence;
    }

}
