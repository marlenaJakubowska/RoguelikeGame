package com.codecool.roguelike;

public abstract class Item extends GameObject {

    private String name;
    private String symbol;

    public Item(String name, String symbol, Coordinates pivot) {
        super(pivot, symbol);
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.symbol;

    }
}
