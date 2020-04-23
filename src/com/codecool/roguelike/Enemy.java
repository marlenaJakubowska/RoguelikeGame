package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends GameObject {


    public Enemy(Coordinates coordinates) {
        super(coordinates, " E");
    }

    public Coordinates getCoord() {
        return this.coord;
    }

//    public void move(Board board) {
//        board.getBoard()[this.coord.getX()][this.coord.getY()] = null;
//        int x = this.coord.getX();
//        int y = this.coord.getY() + 1;
//        this.coord = new Coordinates(x, y);
//        board.getBoard()[this.coord.getX()][this.coord.getY()] = this;
//
//    }

//    public Coordinates toMoveCoordinates(Coordinates direction) {
//        int x = this.coord.getX() + direction.getX();
//        int y = this.coord.getY() + direction.getY();
//        return new Coordinates(x, y);
//    }

}
