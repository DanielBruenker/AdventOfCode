package org.haffson.adventofcode.days.day04;

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
public class Day04Test {

    @Test
    public void testFirstPartReturnExpectedResult() {
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> passPorts = Arrays.asList(
                // Passport 1 - valid
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                // Passport 2 - invalid (missing hgt (the Height field).)
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929",
                "",
                // Passport 3 - valid
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm",
                "",
                // Passport 4 - invalid
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in"
        );
        String expectedResult = "Part 1: " + 2;

        when(fileReadersMock.readFileIntoStringList(anyString(), eq(true)))
                .thenReturn(passPorts);

        Day04 day04 = new Day04(fileReadersMock, "");

        String actualResult = day04.firstPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testSecondPartReturnExpectedResult() {
        FileReaders fileReadersMock = mock(FileReaders.class);
        List<String> passPorts = Arrays.asList(
                // Passport 1 - valid
                "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
                "hcl:#623a2f",
                "",
                // Passport 2 - valid
                "eyr:2029 ecl:blu cid:129 byr:1989",
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
                "",
                // Passport 3 - valid
                "hcl:#888785",
                "hgt:164cm byr:2001 iyr:2015 cid:88",
                "pid:545766238 ecl:hzl",
                "eyr:2022",
                "",
                // Passport 4 - valid
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719",
                "",
                // Passport 5 - invalid
                "eyr:1972 cid:100",
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
                "",
                // Passport 6 - invalid
                "iyr:2019",
                "hcl:#602927 eyr:1967 hgt:170cm",
                "ecl:grn pid:012533040 byr:1946",
                "",
                // Passport 7 - invalid
                "hcl:dab227 iyr:2012",
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
                "",
                // Passport 8 - invalid
                "hgt:59cm ecl:zzz",
                "eyr:2038 hcl:74454a iyr:2023",
                "pid:3556412378 byr:2007"
        );
        String expectedResult = "Part 2: " + 4;

        when(fileReadersMock.readFileIntoStringList(anyString(), eq(true)))
                .thenReturn(passPorts);

        Day04 day04 = new Day04(fileReadersMock, "");

        String actualResult = day04.secondPart();

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}