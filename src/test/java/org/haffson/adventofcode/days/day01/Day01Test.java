package org.haffson.adventofcode.days.day01;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Before;
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

    private Day01 day01;

    @Before
    public void before() {
        this.day01 = new Day01();
    }

    public void testGetDay() {
        int expectedResult = 1;

        int actualResult = this.day01.getDay();

        assertThat(expectedResult).isEqualTo(actualResult);
    }

    @Test
    public void testMultiplyListEntries() {
        int[] values = new int[]{979, 366, 675};
        int expectedResult = 241861950;

        int actualResult = this.day01.multiplyListEntries(values);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testMultiplyListEntriesWithEmptyList() {
        int[] values = new int[]{};
        int expectedResult = 0;

        int actualResult = this.day01.multiplyListEntries(values);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindTwoEntriesThatSumToX() {
        int[] values = new int[]{1721, 979, 366, 299, 675, 1456};
        int[] expectedResult = new int[]{1721, 299};

        int[] actualResult = this.day01.findTwoEntriesThatSumToX(values, 2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindTwoEntriesThatSumToXWithEmptyList() {
        int[] values = new int[]{};
        int[] expectedResult = new int[]{};

        int[] actualResult = this.day01.findTwoEntriesThatSumToX(values, 2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTowEntriesThatSumToXWithNull() {
        this.day01.findTwoEntriesThatSumToX(null, 2020);
    }

    @Test
    public void testFindThreeEntriesThatSumToX() {
        int[] values = new int[]{1721, 979, 366, 299, 675, 1456};
        int[] expectedResult = new int[]{979, 366, 675};

        int[] actualResult = this.day01.findThreeEntriesThatSumToX(values, 2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFindThreeEntriesThatSumToXWithEmptyList() {
        int[] values = new int[]{};
        int[] expectedResult = new int[]{};

        int[] actualResult = this.day01.findThreeEntriesThatSumToX(values, 2020);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindThreeEntriesThatSumToXWithNull() {
        this.day01.findThreeEntriesThatSumToX(null, 2020);
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
