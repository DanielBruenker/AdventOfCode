package org.haffson.adventofcode.days.day04;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PassportControlTest {

    @Test
    public void testControlPassportReturnExpectedResult() {
        Passport validPassport = Passport.fromString("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");
        // It is missing hgt (the height field).
        Passport invalidPassport = Passport.fromString("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929");

        boolean validPassportResult = PassportControl.controlPassport(validPassport, true);
        boolean invalidPassportResult = PassportControl.controlPassport(invalidPassport, true);

        assertThat(validPassportResult).isTrue();
        assertThat(invalidPassportResult).isFalse();
    }

    @Test
    public void testCheckPassportFieldValueReturnExpectedResult() {
           // Case 1: valid field value
        String condition = "(amb|blu|brn|gry|grn|hzl|oth)";
        boolean actualResultCase1 = PassportControl.checkPassportFieldValue(condition, "amb");
        // Case 2: invalid field value
        condition = "(1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in)";
        boolean actualResultCase2 = PassportControl.checkPassportFieldValue(condition, "200cm");

        assertThat(actualResultCase1).isTrue();
        assertThat(actualResultCase2).isFalse();
    }


    @Test
    public void testCheckBirthYearReturnExpectedResult(){
        // (Birth Year) - four digits; at least 1920 and at most 2002.
        // Test at least 1920
        boolean actualResult = PassportControl.checkBirthYear("1920");
        assertThat(actualResult).isTrue();

        // Test at most 2002
        actualResult = PassportControl.checkBirthYear("2002");
        assertThat(actualResult).isTrue();

        // Test later 2020
        actualResult = PassportControl.checkBirthYear("2003");
        assertThat(actualResult).isFalse();

        // Test before 1920
        actualResult = PassportControl.checkBirthYear("1919");
        assertThat(actualResult).isFalse();

        // Test in interval
        actualResult = PassportControl.checkBirthYear("1999");
        assertThat(actualResult).isTrue();
    }

    @Test
    public void testCheckIssueYearReturnExpectedResult(){
        // (Issue Year) - four digits; at least 2010 and at most 2020.
        // Test at least 2010
        boolean actualResult = PassportControl.checkIssueYear("2010");
        assertThat(actualResult).isTrue();

        // Test at most 2020
        actualResult = PassportControl.checkIssueYear("2020");
        assertThat(actualResult).isTrue();

        // Test later 2020
        actualResult = PassportControl.checkIssueYear("2021");
        assertThat(actualResult).isFalse();

        // Test before 2010
        actualResult = PassportControl.checkIssueYear("2009");
        assertThat(actualResult).isFalse();

        // Test in interval
        actualResult = PassportControl.checkIssueYear("2015");
        assertThat(actualResult).isTrue();
    }

    @Test
    public void testCheckExpirationYearExpectedResult(){
        // (Expiration Year) - four digits; at least 2020 and at most 2030.
        // Test at least 2020
        boolean actualResult = PassportControl.checkExpirationYear("2020");
        assertThat(actualResult).isTrue();

        // Test at most 2030
        actualResult = PassportControl.checkExpirationYear("2030");
        assertThat(actualResult).isTrue();

        // Test later 2030
        actualResult = PassportControl.checkExpirationYear("2031");
        assertThat(actualResult).isFalse();

        // Test before 2020
        actualResult = PassportControl.checkExpirationYear("2019");
        assertThat(actualResult).isFalse();

        // Test in interval
        actualResult = PassportControl.checkExpirationYear("2025");
        assertThat(actualResult).isTrue();
    }

    @Test
    public void testCheckHeightExpectedResult(){
        // (Height) - a number followed by either cm or in:
        //      - If cm, the number must be at least 150 and at most 193.
        //      - If in, the number must be at least 59 and at most 76.

        // Test at least 150cm
        boolean actualResult = PassportControl.checkHeight("150cm");
        assertThat(actualResult).isTrue();

        // Test at most 193cm
        actualResult = PassportControl.checkHeight("193cm");
        assertThat(actualResult).isTrue();

        // Test larger 193cm
        actualResult = PassportControl.checkHeight("194cm");
        assertThat(actualResult).isFalse();

        // Test smaller 150cm
        actualResult = PassportControl.checkHeight("149cm");
        assertThat(actualResult).isFalse();

        // Test in interval
        actualResult = PassportControl.checkHeight("177cm");
        assertThat(actualResult).isTrue();


        // Test at least 59in
        actualResult = PassportControl.checkHeight("59in");
        assertThat(actualResult).isTrue();

        // Test at most 76in
        actualResult = PassportControl.checkHeight("76in");
        assertThat(actualResult).isTrue();

        // Test larger 76in
        actualResult = PassportControl.checkHeight("77in");
        assertThat(actualResult).isFalse();

        // Test smaller 59in
        actualResult = PassportControl.checkHeight("58in");
        assertThat(actualResult).isFalse();

        // Test in interval
        actualResult = PassportControl.checkHeight("66in");
        assertThat(actualResult).isTrue();
    }


    @Test
    public void testCheckCheckHairColorExpectedResult(){
        // (Hair Color) - a # followed by exactly six characters 0-9 or a-f.

        // Test valid hair color
        boolean actualResult = PassportControl.checkHairColor("#123abc");
        assertThat(actualResult).isTrue();

        // Test more than 6 characters
        actualResult = PassportControl.checkHairColor("#e7c520fc");
        assertThat(actualResult).isFalse();

        // Tests less than 6 characters
        actualResult = PassportControl.checkHairColor("#e7c52");
        assertThat(actualResult).isFalse();

        // Test other characters different to a-f
        actualResult = PassportControl.checkHairColor("#123abz");
        assertThat(actualResult).isFalse();

        // Test missing #
        actualResult = PassportControl.checkHairColor("123abc");
        assertThat(actualResult).isFalse();
    }


}
