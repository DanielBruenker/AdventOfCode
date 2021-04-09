package org.haffson.adventofcode.days.day03;

import org.haffson.adventofcode.utils.FileReaders;
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
public class Day03Test {

    @Autowired
    private FileReaders fileReaders;

    @Test
    public void testGetDay() {
        Day03 day03 = new Day03();
        int expectedResult = 3;
        int actualResult = day03.getDay();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testFirstPartReturnsExpectedResult(){
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> rows = Arrays.asList(
                ".#...#.......#...#...#.#.#.....",
                "####.....#.#..#...#...........#",
                ".....#...........#......#....#.",
                "......#..#......#.#..#...##.#.#",
                "............#......#...........",
                "...........#.#.#....#.......##.",
                "....#.......#..............#...",
                "........##...#.#.....##...##.#.",
                ".#.#.....##................##..",
                ".##................##..#...##.."
        );

        String expectedResult = "Part 1: " + 6;

        when(fileReadersMock.readFileIntoStringList(anyString()))
                .thenReturn(rows);

        Day03 day03 = new Day03(fileReadersMock, anyString());

        String actualResult = day03.firstPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSecondPartReturnsExpectedResult(){
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> rows = Arrays.asList(
                ".#...#.......#...#...#.#.#.....",
                "####.....#.#..#...#...........#",
                ".....#...........#......#....#.",
                "......#..#......#.#..#...##.#.#",
                "............#......#...........",
                "...........#.#.#....#.......##.",
                "....#.......#..............#...",
                "........##...#.#.....##...##.#.",
                ".#.#.....##................##..",
                ".##................##..#...##.."
        );

        String expectedResult = "Part 2: " + 2;

        when(fileReadersMock.readFileIntoStringList(anyString()))
                .thenReturn(rows);

        Day03 day03 = new Day03(fileReadersMock, anyString());

        String actualResult = day03.secondPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }






}
