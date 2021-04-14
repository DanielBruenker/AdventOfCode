package org.haffson.adventofcode.days.day02;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PasswordPoliceSecondPartTest {

    @Test
    public void testFromPoliceAndPasswordStringExpectedResult() {
        String policeAndPassword = "9-11 k: vclfkkfcdbwwk";
        PasswordPoliceSecondPart expectedResult = new PasswordPoliceSecondPart(8, 10, 'k');

        PasswordPoliceSecondPart actualResult = PasswordPoliceSecondPart.fromPoliceAndPasswordString(policeAndPassword);

        assertThat(actualResult.getFirstIndex()).isEqualTo(expectedResult.getFirstIndex());
        assertThat(actualResult.getSecondIndex()).isEqualTo(expectedResult.getSecondIndex());
        assertThat(actualResult.getCharacter()).isEqualTo(expectedResult.getCharacter());
    }

}
