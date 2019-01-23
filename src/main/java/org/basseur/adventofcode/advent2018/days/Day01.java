package org.basseur.adventofcode.advent2018.days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
public class Day01 implements Days {

    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/Day01Input.txt";

    private HashMap<String, ProblemStatusEnum> problemStatus;
    private Integer[] frequencies;

    public Day01() {
        this.frequencies = FileReaders.readFileIntoArrayOfIntegers(FILE_LOCATION);
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
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
        return "Part 1 - Frequency: " + calculateFrequency();
    }

    @Override
    public String secondPart() {
        return "Part 2 - Frequency reached twice: " + calculateDoubleFrequency();
    }

    private int calculateFrequency() {
        return Arrays.stream(frequencies).mapToInt(a -> a).sum();
    }

    private int calculateDoubleFrequency() {
        Set<Integer> uniqueFrequencies = new HashSet<>();
        int frequency = 0;

        for (int i = 0; true; i++) {
            if (!uniqueFrequencies.add(frequency)) {
                return frequency;
            }
            if (i == (frequencies.length)) {
                i = 0;
            }
            frequency += frequencies[i];
        }
    }
}
