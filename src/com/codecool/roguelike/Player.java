package com.codecool.roguelike;

import java.util.ArrayList;

public class Player extends GameObject {

    private ArrayList<Item> items = new ArrayList<>();

    public Player(Coordinates coordinates) {
        super(coordinates, " @");
    }


    public Coordinates getCoord() {
        return this.coord;
    }

    public void move(Coordinates direction, Board board) {
        board.getBoard()[this.coord.getX()][this.coord.getY()] = null;
        System.out.println(direction.toString());
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        interact(board.getBoard()[x][y]);
        this.coord = new Coordinates(x, y);
        board.getBoard()[this.coord.getX()][this.coord.getY()] = this;
    }


    public void interact(GameObject c) {
        if (c != null && c instanceof Item) {
            Item item = (Item) c;
            items.add(item);
            System.out.println(item.getName().toString());
        }
    }
}