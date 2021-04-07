package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.days.day02.Day02;
import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Day02Test {

    @Autowired
    private FileReaders fileReaders;

    @Test
    public void testGetDay() {
        Day02 day02 = new Day02();
        int expectedResult = 2;
        int actualResult = day02.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
