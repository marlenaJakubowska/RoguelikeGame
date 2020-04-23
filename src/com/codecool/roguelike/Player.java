package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player extends GameObject {

    private List<Item> items = new ArrayList<>();
    private List<String> inventory;

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
            System.out.println(item.getName().toString());
            addToInventory(item.getName());
        }
    }

    public Coordinates toMoveCoordinates(Coordinates direction) {
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        return new Coordinates(x, y);
    }

    public List<String> addToInventory(String name) {

        System.out.println("inventory: ");
        for (int i = 0; i < items.size(); i++) {
            inventory = new ArrayList<>();
            inventory.add(items.get(i).getName());

            for (String s : inventory) {
                System.out.print(String.format("*%s", s));
            }
            System.out.println();
        }
        System.out.println("\n");
        return inventory;
    }

}