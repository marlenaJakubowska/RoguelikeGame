package com.codecool.roguelike;

public class Obstacle extends GameObject {
    int width;
    int height;

    public Obstacle(Coordinates pivot, int width, int height, String symbol) {
        super(pivot, symbol);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
