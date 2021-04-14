package org.haffson.adventofcode.days.day05;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Day05Test {

    @Test
    public void testGetDay() {
        Day05 day05 = new Day05();
        int expectedResult = 5;

        int actualResult = day05.getDay();

        assertThat(expectedResult).isEqualTo(actualResult);
    }

    @Test
    public void testFirstPartReturnsExpectedResult() {
        FileReaders fileReadersMock = mock(FileReaders.class);
        Day05 day05 = new Day05(fileReadersMock, "");
        List<String> testData = Arrays.asList(
                "FBFBBFFRLR",
                "BFFFBBFRRR",
                "FFFBBBFRRR",
                "BBFFBBFRLL"
        );
        String expectedResult = "Part 1: " + 820;

        when(fileReadersMock.readFileIntoStringList(anyString(), eq(false)))
                .thenReturn(testData);

        String actualResult = day05.firstPart();

        assertThat(actualResult).isEqualTo(expectedResult);

    }

}
