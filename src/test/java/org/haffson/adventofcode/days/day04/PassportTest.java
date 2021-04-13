package org.haffson.adventofcode.days.day04;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PassportTest {

    @Test
    public void testFromStringReturnExpectedResult() {
        Passport passport = Passport.fromString("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm");

        assertThat(passport.getFieldValue("ecl")).isEqualTo("gry");
        assertThat(passport.getFieldValue("pid")).isEqualTo("860033327");
        assertThat(passport.getFieldValue("eyr")).isEqualTo("2020");
        assertThat(passport.getFieldValue("hcl")).isEqualTo("#fffffd");
        assertThat(passport.getFieldValue("byr")).isEqualTo("1937");
        assertThat(passport.getFieldValue("iyr")).isEqualTo("2017");
        assertThat(passport.getFieldValue("cid")).isEqualTo("147");
        assertThat(passport.getFieldValue("hgt")).isEqualTo("183cm");
    }
}
