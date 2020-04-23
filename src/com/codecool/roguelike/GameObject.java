package com.codecool.roguelike;

public abstract class GameObject {
    protected Coordinates coord;
    private String symbol;

    public GameObject(Coordinates coordinates, String symbol) {
        this.coord = coordinates;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString() {
        return this.getSymbol();
    }

    public Coordinates getCoord() {
        return this.coord;
    }

}
