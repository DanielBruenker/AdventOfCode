package org.haffson.adventofcode.days.day03;

import java.util.List;

/***
 * This class is used to represent the forest (map) and to count the trees on a toboggan trajectory.
 */
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

    /***
     * This class function can be used to create a Forest object from a string list which contains the map.
     *
     * @param rows list of strings which represent the forest (map)
     * @return the created Forest object
     */
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

    /***
     * This function counts the numbers of trees of the toboggan trajectory for the passed slope.
     *
     * @param slope slope of the toboggan trajectory
     * @return the number of trees
     */
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
