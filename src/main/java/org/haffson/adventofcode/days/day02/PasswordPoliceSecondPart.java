package org.haffson.adventofcode.days.day02;

public class PasswordPoliceSecondPart implements IPasswordPolice{

    private final int firstIndex;
    private final int secondIndex;
    private final char character;

    public PasswordPoliceSecondPart(int firstIndex, int secondIndex, char character) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.character = character;
    }

    static org.haffson.adventofcode.days.day02.PasswordPoliceSecondPart fromPoliceAndPasswordString(String policeAndPassword) {
        String policeString = PasswordPoliceParser.parsePolice(policeAndPassword);
        char character = PasswordPoliceParser.parseCharacter(policeString);
        int firstIndex = PasswordPoliceParser.parseFirstPoliceCondition(policeString) - 1;
        int secondIndex = PasswordPoliceParser.parseSecondPoliceCondition(policeString) - 1;
        return new org.haffson.adventofcode.days.day02.PasswordPoliceSecondPart(firstIndex, secondIndex, character);
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public char getCharacter() {
        return character;
    }

    /***
     * This function can use to validate a password.
     * @param password password as string
     * @return returns true if the password valid..
     */
    @Override
    public boolean validatePassword(String password) {
        return character == password.charAt(firstIndex) ^ character == password.charAt(secondIndex);
    }

}
