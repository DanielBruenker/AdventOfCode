package org.haffson.adventofcode.days.day03;

import java.util.List;

class Forest {

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

        for(int row = 0; row < rows.size(); row++){
            fields[row] = new boolean[rows.get(row).length()];
            for(int col = 0; col < rows.get(row).length(); col++){
                fields[row][col] = rows.get(row).charAt(col) == '#';
            }
        }

        return new Forest(fields);
    }

    public int crossAndCountTrees(Slope slope){
        int treeCount = 0;
        int down = slope.getDown();
        int right = slope.getRight();

        for(int row = 0, col = 0; row < nRows; row += down, col += right){
            treeCount += (fields[row][col % fields[row].length]) ? 1 : 0;
        }

        return treeCount;
    }
}
