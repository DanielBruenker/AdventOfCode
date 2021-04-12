package org.haffson.adventofcode.days.day04;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Implementation for <i>Day 4: Passport Processing</i>.
 */
@Component
public class Day04 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The puzzle inputs */
    private List<String> passPorts; // Passports are separated by an empty line

    private FileReaders fileReaders;

    private String filePath;

    Day04(){
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);
    }

    @Autowired
    Day04(FileReaders fileReaders, @Value("${day4.file}") String filePath){
        this();
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    /**
     * This Method is used to load the puzzle inputs before execute on of the puzzle parts.
     */
    private void loadPuzzleInputs() {
        if (passPorts == null) {
            List<String> data = fileReaders.readFileIntoStringList(filePath, true);
            passPorts = PassportParser.parsePassports(data);
        }
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

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /***
     * This function is used to calculate the solution for part 1.
     *
     * @return the number of valid passports
     */
    private int calculatePart1() {
        int numberOfValidPassports = 0;
        for(String passport : passPorts){
            boolean isValid = PassportControl.controlPassport(passport);
            numberOfValidPassports += (isValid) ? 1 : 0;
        }
        return numberOfValidPassports;

    }
}




