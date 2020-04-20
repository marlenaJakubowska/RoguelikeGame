package com.codecool.roguelike;

public class Coordinates {
    private int x;
    private int y;

    public static final Coordinates w = new Coordinates(-1, 0);
    public static final Coordinates s = new Coordinates(1, 0);
    public static final Coordinates a = new Coordinates(0, -1);
    public static final Coordinates d = new Coordinates(0, 1);



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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "x: " + this.x + " y: " + this.y;
    }
}
