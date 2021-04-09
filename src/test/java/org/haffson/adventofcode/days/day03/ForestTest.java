package org.haffson.adventofcode.days.day03;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ForestTest {

    @Test
    public void testFromStringListReturnExpectedResult(){

        List<String> rows = Arrays.asList(
            ".#...#.......#...#...#.#.#.....",
            "####.....#.#..#...#...........#"
        );

        boolean[][] fields = new boolean[rows.size()][];
        fields[0] = new boolean[]{
                false, true, false, false, false, true, false, false, false, false,
                false, false, false, true, false, false, false, true, false, false,
                false, true, false, true, false, true, false, false, false, false,
                false
        };
        fields[1] = new boolean[]{
                true, true, true, true, false, false, false, false, false, true, false,
                true, false, false, true, false, false, false, true, false, false, false,
                false, false, false, false, false, false, false, false, true
        };

        Forest actualResult = Forest.fromMapStringList(rows);

        assertThat(actualResult.getFields()).isEqualTo(fields);
        assertThat(actualResult.getNRows()).isEqualTo(2);
        assertThat(actualResult.getNColumns()).isEqualTo(31);
    }

    @Test
    public void testCrossAndCountTressReturnExpectedResult(){
        List<String> rows = Arrays.asList(
                ".#...#.......#...#...#.#.#.....",
                "####.....#.#..#...#...........#",
                ".....#...........#......#....#.",
                "......#..#......#.#..#...##.#.#"
        );
        Slope slope = new Slope(3, 1);
        int expectedResult = 2;
        Forest forest = Forest.fromMapStringList(rows);

        int actualResult = forest.crossAndCountTrees(slope);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
