package org.haffson.adventofcode.days.day01;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Implementation for <i>Day 1: Report Repair</i>.
 */
@Component
public class Day01 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The puzzle inputs */
    private int[] numbers;

    private FileReaders fileReaders;

    private String filePath;

    public Day01(){
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    Day01(int[] numbers) {
        this();
        this.numbers = numbers;
    }

    @Autowired
    Day01(FileReaders fileReaders, @Value("${day1.file}") String filePath) {
        this(null);
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        this.loadPuzzleInputs();
        return "Part 1: " + calculatePart1();
    }

    @Override
    public String secondPart() {
        this.loadPuzzleInputs();
        return "Part 2: " + calculatePart2();
    }

    /**
     * This Method is used to load the puzzle inputs before execute on of the puzzle parts.
     */
    private void loadPuzzleInputs() {
        if (this.numbers == null) {
            this.numbers = this.fileReaders.readFileIntoArrayOfIntegers(this.filePath);
        }
    }

    /**
     * Primary method for Day 1, Part 1.
     * Calculates the Report
     *
     * @return returns the product of the multiplication of two numbers that add up to 2020.
     */
    private int calculatePart1() {
        int[] entries = this.findTwoEntriesThatSumToX(2020);
        return multiplyListEntries(entries);
    }


    /**
     * Primary method for Day 1, Part 2.
     * Calculates the Report
     *
     * @return returns the product of the multiplication of three numbers that add up to 2020.
     */
    private int calculatePart2() {
        int[] entries = this.findThreeEntriesThatSumToX(2020);
        return multiplyListEntries(entries);
    }

    /***
     * This helper function calculates the product of all list entries.
     *
     * @param values values
     * @return returns the product of all list entries.
     */
    static int multiplyListEntries(int[] values) {
        if (values.length > 0) {
            return Arrays.stream(values).reduce(1, (a, b) -> a * b);
        } else {
            return 0;
        }
    }

    /***
     * This function can use to find two list entries in numbers that add up to the value x.
     *
     * @return returns the list entries witch add up to x.
     */
    int[] findTwoEntriesThatSumToX(int x) throws NullPointerException {

        if (this.numbers == null) {
            throw new NullPointerException("numbers must be not null!");
        }

        int[] entries = new int[]{};
        outer:
        for (int i = 0; i < this.numbers.length - 1; i++) {
            for (int j = i + 1; j < this.numbers.length - 1; j++) {
                if (this.numbers[i] + this.numbers[j] == x) {
                    entries = new int[]{this.numbers[i], this.numbers[j]};
                    break outer;
                }
            }
        }
        return entries;
    }


    /***
     * This function can use to find three list entries in numbers that add up to the value x.
     *
     * @param x sum of the three list entries
     * @return returns the list entries witch add up to x.
     */
    int[] findThreeEntriesThatSumToX(int x) throws NullPointerException {

        if (this.numbers == null) {
            throw new NullPointerException("numbers must be not null!");
        }

        int[] entries = new int[]{};
        outer:
        for (int i = 0; i < this.numbers.length - 3; i++) {
            for (int j = i + 1; j < this.numbers.length - 2; j++) {
                for (int k = j + 1; k < this.numbers.length - 1; k++) {
                    if (this.numbers[i] + this.numbers[j] + this.numbers[k] == x) {
                        entries = new int[]{this.numbers[i], this.numbers[j], this.numbers[k]};
                        break outer;
                    }
                }
            }
        }
        return entries;
    }
}
