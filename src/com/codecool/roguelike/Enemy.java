package com.codecool.roguelike;

public class Enemy extends Character {
    Coordinates coord;
    final String SYMBOL = " E";

    public Enemy() {
        this.coord = new Coordinates(8,8);
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    @Override
    public String getSymbol() {
        return this.SYMBOL;
    }

    @Override
    public void move(Coordinates direction) {

    }
}
