package org.haffson.adventofcode.days.day02;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PasswordPoliceFirstPartTest {

    @Test
    public void testFromPoliceAndPasswordStringExpectedResult() {
        String policeAndPassword = "9-11 k: vclfkkfcdbwwk";
        PasswordPoliceFirstPart expectedResult = new PasswordPoliceFirstPart(9, 11, 'k');

        PasswordPoliceFirstPart actualResult = PasswordPoliceFirstPart.fromPoliceAndPasswordString(policeAndPassword);

        assertThat(actualResult.getMinOccurrence()).isEqualTo(expectedResult.getMinOccurrence());
        assertThat(actualResult.getMacOccurrence()).isEqualTo(expectedResult.getMacOccurrence());
        assertThat(actualResult.getCharacter()).isEqualTo(expectedResult.getCharacter());
    }

}