package org.haffson.adventofcode.days.day02;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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

    @Test
    public void testFirstPartReturnsExpectedResult() {
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> stringList = Arrays.asList(
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        );
        String expectedResult = "Part 1: " + 2;

        when(fileReadersMock.readFileIntoStringList(anyString()))
                .thenReturn(stringList);

        Day02 day02 = new Day02(fileReadersMock, anyString());

        String actualResult = day02.firstPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSecondPartReturnsExpectedResult() {
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> stringList = Arrays.asList(
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        );
        String expectedResult = "Part 2: " + 1;

        when(fileReadersMock.readFileIntoStringList(anyString()))
                .thenReturn(stringList);

        Day02 day02 = new Day02(fileReadersMock, anyString());

        String actualResult = day02.secondPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}