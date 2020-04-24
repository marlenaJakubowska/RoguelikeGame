package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.List;

public class Player extends GameObject {

    private List<Item> items = new ArrayList<>();

    public Player(Coordinates coordinates) {
        super(coordinates, " @");
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public void move(Coordinates direction, Board board) {
        board.getBoard()[this.coord.getX()][this.coord.getY()] = null;
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        interact(board.getBoard()[x][y]);
        this.coord = new Coordinates(x, y);
        board.getBoard()[this.coord.getX()][this.coord.getY()] = this;
    }

    public void interact(GameObject c) {
        if (c instanceof Item) {
            Item item = (Item) c;
            items.add(item);
            printInventory();
        }
    }

    public Coordinates toMoveCoordinates(Coordinates direction) {
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        return new Coordinates(x, y);
    }

    public void printInventory() {
        System.out.println("inventory: ");
        for (Item item : items) {
            System.out.print(String.format("*%s\n", item.getName()));
        }
        System.out.println("\n");
    }
}