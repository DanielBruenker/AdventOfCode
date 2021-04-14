package org.haffson.adventofcode.utils;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * File readers to load and parse input files for the puzzles.
 */
@Component
public class FileReaders {

    public int[] readFileIntoArrayOfIntegers(String path) {
        return readFileIntoStringList(path)
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }


    public List<String> readFileIntoStringList(String path) {
        List<String> data = new ArrayList<>();
        InputStream inputStream = FileReaders.class.getResourceAsStream(path);
        try (Scanner scanner = new Scanner(Objects.requireNonNull(inputStream))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    data.add(line);
                }
            }
        }
        return data;
    }
}

