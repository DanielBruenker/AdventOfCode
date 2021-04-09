package org.haffson.adventofcode.days.day03;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Implementation for <i>Day 3: Toboggan Trajectory</i>.
 */
@Component
public class Day03 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    private List<String> rows;

    private FileReaders fileReaders;

    private String filePath;

    private final List<Slope> SLOPES = Arrays.asList(
            new Slope(1, 1),
            new Slope(3, 1),
            new Slope(5,1),
            new Slope(7,1),
            new Slope(1, 2)
    );

    Day03(){
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    @Autowired
    Day03(FileReaders fileReaders, @Value("${day3.file}") String filePath){
        this();
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    /**
     * This Method is used to load the puzzle inputs before execute on of the puzzle parts.
     */
    private void loadPuzzleInputs() {
        if (rows == null) {
            rows = fileReaders.readFileIntoStringList(filePath);
        }
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

    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    private int calculatePart1(){
        Forest forest = Forest.fromMapStringList(rows);
        return forest.crossAndCountTrees(SLOPES.get(1));
    }

    private long calculatePart2() {
        Forest forest = Forest.fromMapStringList(rows);
        long totalNumberOfTrees = 1;
        int numberOfTrees;
        for(Slope slope : SLOPES){
            numberOfTrees = forest.crossAndCountTrees(slope);
            totalNumberOfTrees *= (numberOfTrees > 0) ? numberOfTrees : 1;
        }
        return totalNumberOfTrees;
    }

}
