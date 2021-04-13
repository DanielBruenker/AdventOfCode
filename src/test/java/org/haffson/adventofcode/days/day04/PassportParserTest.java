package org.haffson.adventofcode.days.day04;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PassportParserTest {

    @Test
    public void testParsePassportsReturnExpectedResult() {
        List<String> testData = Arrays.asList(
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
        List<Passport> expectedResult = Arrays.asList(
                Passport.fromString("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"), // Passport 1
                Passport.fromString("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929"),           // Passport 2
                Passport.fromString("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"),         // Passport 3
                Passport.fromString("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in")                    // Passport 4
        );

        List<Passport> actualResult = PassportParser.parsePassports(testData);

        for (int i = 0; i < actualResult.size(); i++) {
            assertThat(actualResult.get(i).toString()).isEqualTo(expectedResult.get(i).toString());
        }
    }

}
