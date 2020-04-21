package com.codecool.roguelike;

public class Player extends Character {
    Coordinates coord;
    String symbol = " @";

    public Player() {
        this.coord = new Coordinates(5,5);
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    @Override
    public void move(Coordinates direction) {
        System.out.println(direction.toString());
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();

        this.coord = new Coordinates(x, y);
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}