package com.codecool.roguelike;

public class Food extends Item {

    Food(String name, String symbol, Coordinates coord, int height, int width) {
        super(width, height, name, symbol, coord);
    }

}
