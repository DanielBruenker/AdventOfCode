package org.haffson.adventofcode.days.day01;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Day01Test {

    @Autowired
    private FileReaders fileReaders;

    @Value("${day1.file}")
    private String filePath;


    public void testGetDay() {
        Day01 day01 = new Day01(null);
        int expectedResult = 1;

        int actualResult = day01.getDay();

        assertThat(expectedResult).isEqualTo(actualResult);
    }

    @Test
    public void testMultiplyListEntries() {
        int[] values = new int[]{979, 366, 675};
        int expectedResult = 241861950;

        int actualResult = Day01.multiplyListEntries(values);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testMultiplyListEntriesWithEmptyList() {
        int[] values = new int[]{};
        int expectedResult = 0;

        int actualResult = Day01.multiplyListEntries(values);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindTwoEntriesThatSumToX() {
        Day01 day01 = new Day01(new int[]{1721, 979, 366, 299, 675, 1456});

        int[] expectedResult = new int[]{1721, 299};

        int[] actualResult = day01.findTwoEntriesThatSumToX(2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindTwoEntriesThatSumToXWithEmptyList() {
        Day01 day01 = new Day01(new int[]{});
        int[] expectedResult = new int[]{};

        int[] actualResult = day01.findTwoEntriesThatSumToX(2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindThreeEntriesThatSumToX() {
        Day01 day01 = new Day01(new int[]{1721, 979, 366, 299, 675, 1456});
        int[] expectedResult = new int[]{979, 366, 675};

        int[] actualResult = day01.findThreeEntriesThatSumToX( 2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindThreeEntriesThatSumToXWithEmptyList() {
        Day01 day01 = new Day01(new int[]{});
        int[] expectedResult = new int[]{};

        int[] actualResult = day01.findThreeEntriesThatSumToX( 2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(expected = NullPointerException.class)
    public void testFindThreeEntriesThatSumToXWithNull() {
        Day01 day01 = new Day01(null);

        day01.findThreeEntriesThatSumToX( 2020);
    }

    @Test
    public void testFirstPartReturnsExpectedResult() {
        Day01 day01 = new Day01(fileReaders, filePath);
        String expectedResult = "Part 1: " + 514579;

        String actualResult = day01.firstPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSecondPartReturnsExpectedResult() {
        Day01 day01 = new Day01(fileReaders, filePath);
        String expectedResult = "Part 2: " + 241861950;

        String actualResult = day01.secondPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
