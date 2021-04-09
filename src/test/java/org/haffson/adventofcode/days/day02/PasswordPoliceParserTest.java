package org.haffson.adventofcode.days.day02;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PasswordPoliceParserTest {

    @Test
    public void testParsePasswordExpectedResult() {
        String policeAndPassword = "9-10 b: bbktbbbxhfbpb";
        String expectedResult = "bbktbbbxhfbpb";

        String actualResult = PasswordPoliceParser.parsePassword(policeAndPassword);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testParsPoliceExpectedResult() {
        String policeAndPassword = "9-10 b: bbktbbbxhfbpb";
        String expectedResult = "9-10 b";

        String actualResult = PasswordPoliceParser.parsePolice(policeAndPassword);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testParseFirstPoliceConditionExpectedResult() {
        String police = "9-10 b";
        int expectedResult = 9;

        int actualResult = PasswordPoliceParser.parseFirstPoliceCondition(police);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testParseSecondPoliceConditionExpectedResult() {
        String police = "9-10 b";
        int expectedResult = 10;

        int actualResult = PasswordPoliceParser.parseSecondPoliceCondition(police);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void testParseCharacterExpectedResult() {
        String police = "9-10 b";
        char expectedResult = 'b';

        char actualResult = PasswordPoliceParser.parseCharacter(police);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}