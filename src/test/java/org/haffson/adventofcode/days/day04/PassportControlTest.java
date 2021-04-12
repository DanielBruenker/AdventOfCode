package org.haffson.adventofcode.days.day04;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PassportControlTest {

    @Test
    public void testControlPassportReturnExpectedResult() {
        String validPassport = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";
        // It is missing hgt (the Height field).
        String invalidPassport = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929";

        boolean validPassportResult = PassportControl.controlPassport(validPassport);
        boolean invalidPassportResult = PassportControl.controlPassport(invalidPassport);

        assertThat(validPassportResult).isTrue();
        assertThat(invalidPassportResult).isFalse();
    }

    @Test
    public void testCheckPassportFieldReturnExpectedResult() {
        String testPassport = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929";

        // Case 1: Existing field
        String condition = "(amb|blu|brn|gry|grn|hzl|oth)";
        boolean actualResultCase1 = PassportControl.checkPassportField("ecl", "",  testPassport);
        // Case 2: Missing Field
        condition = "(1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in)";
        boolean actualResultCase2 = PassportControl.checkPassportField("hgt", "", testPassport);

        assertThat(actualResultCase1).isTrue();
        assertThat(actualResultCase2).isFalse();
    }


}