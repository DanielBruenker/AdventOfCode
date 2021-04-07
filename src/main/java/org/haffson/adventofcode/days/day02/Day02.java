package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    private List<String> passwords;


    Day02() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    @Autowired
    public Day02(FileReaders fileReaders, @Value("{$day2.file}") String filePath) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.UNSOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    /**
     * This Method is used to load the puzzle inputs before execute on of the puzzle parts.
     */
    private void loadPuzzleInputs() {
        if (passwords == null) {
            passwords = fileReaders.readFileIntoStringList(filePath);
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
        return null;
    }

    @Override
    public String secondPart() {
        return null;
    }


}