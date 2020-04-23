package com.codecool.roguelike;

public abstract class Item extends GameObject {

    private String name;
    private String symbol;
    private int height;
    private int width;

    public Item(int width, int height, String name, String symbol, Coordinates pivot) {
        super(pivot, symbol);
        this.name = name;
        this.symbol = symbol;
        this.height = height;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
