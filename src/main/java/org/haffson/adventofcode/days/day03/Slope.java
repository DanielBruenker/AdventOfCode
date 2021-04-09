package org.haffson.adventofcode.days.day03;

/**
 * The class is used in Day03 to declare different slopes and pass these to
 * the crossAndCountTrees methode of the Forest class.
 */
class Slope {

    private final Integer down; //Steps down
    private final Integer right; //Steps to the right

    public Slope(Integer right, Integer down) {
        this.down = down;
        this.right = right;
    }

    public Integer getDown() {
        return down;
    }

    public Integer getRight() {
        return right;
    }

}
