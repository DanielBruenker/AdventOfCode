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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation for <i>Day 2</i>.
 */
@Component
public class Day02 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    private FileReaders fileReaders;

    private String filePath;

    private List<String> policeAndPasswordList;


    Day02() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    @Autowired
    public Day02(FileReaders fileReaders, @Value("${day2.file}") String filePath) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    /**
     * This Method is used to load the puzzle inputs before execute on of the puzzle parts.
     */
    private void loadPuzzleInputs() {
        if (policeAndPasswordList == null) {
            policeAndPasswordList = fileReaders.readFileIntoStringList(filePath);
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
        loadPuzzleInputs();
        return "Part 2: " + calculatePart2();
    }

    private int calculatePart1() {
        int validPasswordCount = 0;
        for (String policeAndPassword : policeAndPasswordList) {
            String password = PasswordPoliceParser.parsePassword(policeAndPassword);
            PasswordPoliceFirstPart police = PasswordPoliceFirstPart.fromPoliceAndPasswordString(policeAndPassword);
            if (police.validatePassword(password)) {
                validPasswordCount++;
            }
        }
        return validPasswordCount;
    }


    private int calculatePart2() {
        int validPasswordCount = 0;
        for (String policeAndPassword : policeAndPasswordList) {
            String password = PasswordPoliceParser.parsePassword(policeAndPassword);
            PasswordPoliceSecondPart police = PasswordPoliceSecondPart.fromPoliceAndPasswordString(policeAndPassword);
            if (police.validatePassword(password)) {
                validPasswordCount++;
            }
        }
        return validPasswordCount;
    }


}


class PasswordPoliceParser {

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


interface IPasswordPolice {

    boolean validatePassword(String password);

}


class PasswordPoliceFirstPart implements IPasswordPolice {

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

class PasswordPoliceSecondPart implements IPasswordPolice {

    private final int firstIndex;
    private final int secondIndex;
    private final char character;

    public PasswordPoliceSecondPart(int firstIndex, int secondIndex, char character) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.character = character;
    }

    static PasswordPoliceSecondPart fromPoliceAndPasswordString(String policeAndPassword) {
        String policeString = PasswordPoliceParser.parsePolice(policeAndPassword);
        char character = PasswordPoliceParser.parseCharacter(policeString);
        int firstIndex = PasswordPoliceParser.parseFirstPoliceCondition(policeString) - 1;
        int secondIndex = PasswordPoliceParser.parseSecondPoliceCondition(policeString) - 1;
        return new PasswordPoliceSecondPart(firstIndex, secondIndex, character);
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


