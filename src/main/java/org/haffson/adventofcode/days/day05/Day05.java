package org.haffson.adventofcode.days.day05;

import org.haffson.adventofcode.ProblemStatusEnum;
import org.haffson.adventofcode.days.Days;
import org.haffson.adventofcode.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * Implementation for <i>Day 5: Binary Boarding</i>.
 */
@Component
public class Day05 implements Days {

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    private FileReaders fileReaders;
    private String filePath;

    private static final int MAX_ROW_NUMBER = 128;
    private static final int MAX_SEATS_PER_ROW = 8;

    private static final int[] ROW_PLAN = initRowPlan();
    private static final int[] SEAT_PLAN = intSeatPlan();

    private List<String> boardingPassNumbers;

    public Day05() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    @Autowired
    Day05(FileReaders fileReaders, @Value("${day5.file}") String filePath) {
        this();
        this.fileReaders = fileReaders;
        this.filePath = filePath;
    }

    @Override
    public int getDay() {
        return 5;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        this.loadPuzzleInputs();
        return "Part 1: " + calculatePart1();
    }

    @Override
    public String secondPart() {
        this.loadPuzzleInputs();
        return "Part 2: " + calculatePart2();
    }


    private void loadPuzzleInputs() {
        if (boardingPassNumbers == null) {
            boardingPassNumbers = fileReaders.readFileIntoStringList(filePath, false);
        }
    }

    private int calculatePart1() {
        List<Integer> seatIDs = new ArrayList<>();
        for (String boardingPassNumber : boardingPassNumbers) {
            int rowNumber = findRowNumber(boardingPassNumber);
            int seatNumber = findSeatNumber(boardingPassNumber);
            int seatID = calculateSeatID(rowNumber, seatNumber);
            seatIDs.add(seatID);
        }
        return findMaxSeatID(seatIDs);
    }

    private int calculatePart2() {
        Map<Integer, String> seatingArrangement = assignSeats(boardingPassNumbers);
        return findMySeatID(seatingArrangement);
    }

    static Map<Integer, String> assignSeats(List<String> boardingPassNumbers){
        Map<Integer, String> seatingArrangement = createSeatingArrangementMap();
        for (String boardingPassNumber : boardingPassNumbers) {
            int rowNumber = findRowNumber(boardingPassNumber);
            int seatNumber = findSeatNumber(boardingPassNumber);
            int seatID = calculateSeatID(rowNumber, seatNumber);
            seatingArrangement.put(seatID, boardingPassNumber);
        }
        return seatingArrangement;
    }

    static int findMySeatID(Map<Integer, String> seatingArrangement){
        String previous, current, next = null;
        int mySeatID = -1;
        for(int seatID = 0; seatID < seatingArrangement.size(); seatID++){
            previous = (seatID > 0) ? seatingArrangement.get(seatID - 1) : null;
            current = seatingArrangement.get(seatID);
            next = (seatID + 1 < seatingArrangement.size()) ? seatingArrangement.get(seatID + 1) : null;

            if(previous != null && current == null && next != null){
                mySeatID = seatID;
                break;
            }
        }
        return mySeatID;
    }

    static Map<Integer, String> createSeatingArrangementMap(){
        Map<Integer, String> seatingArrangement = new HashMap<>();
        for(int row = 0; row < MAX_ROW_NUMBER; row++){
            for(int seat = 0; seat < MAX_ROW_NUMBER; seat++){
                int seatID = calculateSeatID(row, seat);
                seatingArrangement.put(seatID, null);
            }
        }
        return seatingArrangement;
    }

    static int findRowNumber(String boardingPassNumber){
        char[] characters = boardingPassNumber.toCharArray();
        int[] possibleRows = ROW_PLAN;
        for(int i = 0; i < characters.length - 3; i++){
            switch (characters[i]){
                case 'F':
                    possibleRows = Arrays.copyOfRange(possibleRows, 0, possibleRows.length / 2);
                    break;
                case 'B':
                    possibleRows = Arrays.copyOfRange(possibleRows, possibleRows.length / 2, possibleRows.length);
                    break;
                default:
                    break;
            }
        }
        return possibleRows[0];
    }

    static int findSeatNumber(String boardingPassNumber){
        char[] characters = boardingPassNumber.toCharArray();
        int[] possibleSeats = SEAT_PLAN;
        for(int i = characters.length - 3; i < characters.length; i++){
            switch (characters[i]){
                case 'R':
                    possibleSeats = Arrays.copyOfRange(possibleSeats, possibleSeats.length / 2, possibleSeats.length);
                    break;
                case 'L':
                    possibleSeats = Arrays.copyOfRange(possibleSeats, 0, possibleSeats.length / 2);
                    break;
                default:
                    break;
            }
        }
        return possibleSeats[0];
    }



    static int calculateSeatID(int rowNumber, int seatNumber){
        return rowNumber * MAX_SEATS_PER_ROW + seatNumber;
    }

    static int findMaxSeatID(List<Integer> seatIDs){
        return seatIDs.stream()
                .mapToInt(v -> v)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    static int[] initRowPlan() {
        int[] rows = new int[MAX_ROW_NUMBER];
        for (int i = 0; i < MAX_ROW_NUMBER; i++) {
            rows[i] = i;
        }
        return rows;
    }

    static int[] intSeatPlan() {
        int[] rows = new int[MAX_SEATS_PER_ROW];
        for (int i = 0; i < MAX_SEATS_PER_ROW; i++) {
            rows[i] = i;
        }
        return rows;
    }
}

