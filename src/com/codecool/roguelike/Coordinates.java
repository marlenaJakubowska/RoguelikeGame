package com.codecool.roguelike;

import java.util.Arrays;
import java.util.List;

public class Coordinates {
    private final int x;
    private final int y;

    public static final Coordinates UP = new Coordinates(-1, 0);
    public static final Coordinates DOWN = new Coordinates(1, 0);
    public static final Coordinates LEFT = new Coordinates(0, -1);
    public static final Coordinates RIGHT = new Coordinates(0, 1);
    public static final List<Coordinates> POSSIBLE_DIRECTIONS = Arrays.asList(UP, DOWN, LEFT, RIGHT);

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "x: " + this.x + " y: " + this.y;
    }
}