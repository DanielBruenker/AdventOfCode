package org.haffson.adventofcode.days.day03;

import java.util.List;

public class Forest {

    private final boolean[][] fields;
    private final int nColumns;
    private final int nRows;

    public Forest(boolean[][] fields){
        this.fields = fields;
        this.nRows = fields.length;
        this.nColumns = fields[0].length;
    }

    public boolean[][] getFields() {
        return fields;
    }

    public int getNColumns() {
        return nColumns;
    }

    public int getNRows() {
        return nRows;
    }

    public static Forest fromMapStringList(List<String> rows){
        boolean[][] fields = new boolean[rows.size()][];
        for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++){
            fields[rowIndex] = new boolean[rows.get(rowIndex).length()];
            for(int columnIndex = 0; columnIndex < rows.get(rowIndex).length(); columnIndex++){
                fields[rowIndex][columnIndex] = rows.get(rowIndex).charAt(columnIndex) == '#';
            }
        }
        return new Forest(fields);
    }

    public int crossAndCountTrees(int rightSteps, int downSteps){
        int treeCount = 0;
        for(int rowIndex = 0, columnIndex = 0; rowIndex < nRows; rowIndex += downSteps, columnIndex += rightSteps){
            treeCount += (fields[rowIndex][columnIndex % fields[rowIndex].length]) ? 1 : 0;
        }
        return treeCount;
    }
}
