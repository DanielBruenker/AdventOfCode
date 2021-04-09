package org.haffson.adventofcode.days.day03;

class Slope {

    private final Integer down;
    private final Integer right;

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
