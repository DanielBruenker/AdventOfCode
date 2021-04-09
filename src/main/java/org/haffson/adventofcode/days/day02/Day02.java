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


