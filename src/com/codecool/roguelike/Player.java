package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.HashMap;
<<<<<<< HEAD

public class Player extends GameObject {

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<String> inventory;
    private HashMap<String, String> itemInventory;

=======
import java.util.List;

public class Player extends GameObject {

    private List<Item> items = new ArrayList<>();
    private List<String> inventory;
    private HashMap<String, String> itemInventory;
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b

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
<<<<<<< HEAD
=======
            System.out.println(item.getName().toString());
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b
            addToInventory(item.getName());
        }
    }

<<<<<<< HEAD
=======
    public Coordinates toMoveCoordinates(Coordinates direction) {
        int x = this.coord.getX() + direction.getX();
        int y = this.coord.getY() + direction.getY();
        return new Coordinates(x, y);
    }

>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b
    public HashMap<String, String> addToInventory(String name) {

        System.out.println("inventory: ");
        for (int i = 0; i < items.size(); i++) {
<<<<<<< HEAD
            inventory = new ArrayList<String>();
=======
            inventory = new ArrayList<>();
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b
            inventory.add(items.get(i).getName());

            for (String s : inventory) {
                System.out.print(String.format("*%s", s));
            }
            System.out.println();
<<<<<<< HEAD
            }
        System.out.println("\n");
        return itemInventory;
    }
=======
        }
        System.out.println("\n");
        return itemInventory;
    }

>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b
}