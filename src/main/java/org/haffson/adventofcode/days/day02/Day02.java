package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Implementation for <i>Day 2</i>.
 */
@Component
public class Day02 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    private FileReaders fileReaders;

    private String filePath;

    private List<String> passwordWithPoliceList;


    Day02() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    @Autowired
    public Day02(FileReaders fileReaders, @Value("{$day2.file}") String filePath) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    /**
     * This Method is used to load the puzzle inputs before execute on of the puzzle parts.
     */
    private void loadPuzzleInputs() {
        if (passwordWithPoliceList == null) {
            passwordWithPoliceList = fileReaders.readFileIntoStringList(filePath);
        }
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        loadPuzzleInputs();
        return "Part 1: " + calculatePart1();
    }

    @Override
    public String secondPart() {
        return null;
    }

    private int calculatePart1() {
        int validPasswordCount = 0;
        for (String passwordAndPolice : passwordWithPoliceList) {
            // Parse password and police
            String policeStr = passwordAndPolice.substring(0, 5);
            String password = passwordAndPolice.substring(7);

            PasswordPolice police = PasswordPolice.fromString(policeStr);

            if (police.validatePassword(password)) {
                validPasswordCount++;
            }
        }
        return validPasswordCount;
    }
}


class PasswordPolice {

    private final int minOccurrence;
    private final int macOccurrence;
    private final char character;

    public PasswordPolice(char character, int minOccurrence, int macOccurrence) {
        this.character = character;
        this.minOccurrence = minOccurrence;
        this.macOccurrence = macOccurrence;

    }

    static PasswordPolice fromString(String policeStr) {
        if (!PasswordPolice.isPasswordPoliceStringValid(policeStr)) {
            throw new IllegalArgumentException("Password police string ist not valid!");
        }

        char character = policeStr.charAt(4);
        int minOccurrence = Character.getNumericValue(policeStr.charAt(0));
        int maxOccurrence = Character.getNumericValue(policeStr.charAt(2));

        return new PasswordPolice(character, minOccurrence, maxOccurrence);
    }

    static boolean isPasswordPoliceStringValid(String policeStr) {
        return policeStr.matches("[\\d][-][\\d][\\s][a-z]");
    }

    public boolean validatePassword(String password) {
        int occurrence = StringUtils.countOccurrencesOf(password, this.character + "");
        return minOccurrence <= occurrence && occurrence <= macOccurrence;
    }

}
