package org.haffson.adventofcode.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReadersTest {

    @Autowired
    FileReaders fileReaders;

    @Test
    public void testReadFileIntoStringListWithEmptyLine(){
        String filePath = "/utilsTestFiles/fileReadersExampleInputWithEmptyLine.txt";
        List<String> expectedResult = Arrays.asList(
                "1721",
                "979",
                "366",
                "299",
                "675",
                "1456"
        );

        List<String> actualResult = fileReaders.readFileIntoStringList(filePath, false);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testReadFileIntoStringListWithoutEmptyLine(){
        String filePath = "/utilsTestFiles/fileReadersExampleInputWithEmptyLine.txt";
        List<String> expectedResult = Arrays.asList(
                "1721",
                "979",
                "366",
                "299",
                "675",
                "1456"
        );

        List<String> actualResult = fileReaders.readFileIntoStringList(filePath, false);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void testReadFileIntoArrayOfIntegersWithValidNumbers(){
        FileReaders fileReadersSpy = spy(FileReaders.class);
        List<String> values = Arrays.asList(
                "1721",
                "979",
                "366",
                "299",
                "675",
                "1456"
        );
        int[] expectedResult = new int[]{1721, 979, 366, 299, 675, 1456};
        when(fileReadersSpy.readFileIntoStringList(anyString(), false))
                .thenReturn(values);

        int[] actualResult = fileReadersSpy.readFileIntoArrayOfIntegers(anyString());

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test(expected = NumberFormatException.class)
    public void testReadFileIntoArrayOfIntegersWithNotValidNumbers() {
        FileReaders fileReadersSpy = spy(FileReaders.class);
        List<String> values = Arrays.asList(
                "One",
                "Not valid number!"
        );
        when(fileReadersSpy.readFileIntoStringList(anyString(), false))
                .thenReturn(values);

        fileReadersSpy.readFileIntoArrayOfIntegers(anyString());
    }

}
