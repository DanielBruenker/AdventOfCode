package org.haffson.adventofcode.days.day04;

import org.haffson.adventofcode.utils.FileReaders;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Day04Test {

    @Test
    public void testFirstPartReturnExpectedResult(){
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> passPorts = Arrays.asList(
                // Passport 1
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                // Passport 2
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929",
                "",
                // Passport 3
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm",
                "",
                // Passport 4
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in"
        );
        String expectedResult = "Part 1: " + 2;

        when(fileReadersMock.readFileIntoStringList(anyString()))
                .thenReturn(passPorts);

        Day04 day04 = new Day04(fileReadersMock, anyString());

        String actualResult = day04.firstPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }



}
