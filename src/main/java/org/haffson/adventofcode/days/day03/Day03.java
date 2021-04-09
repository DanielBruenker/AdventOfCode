package org.haffson.adventofcode.days.day03;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.springframework.stereotype.Component;

import java.util.HashMap;


/**
 * Implementation for <i>Day 3: Toboggan Trajectory</i>.
 */
@Component
public class Day03 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    public Day03(){
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.UNSOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);
    }


    @Override
    public String firstPart() {
        return null;
    }

    @Override
    public String secondPart() {
        return null;
    }

    @Override
    public int getDay() {
        return 0;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

}
