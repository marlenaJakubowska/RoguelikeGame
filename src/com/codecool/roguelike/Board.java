package com.codecool.roguelike;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.ListIterator;
=======
import java.util.List;
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b

public class Board {

    private GameObject[][] board;
    private List<Item> items = new ArrayList<>();
    private List<Obstacle> obstacles = new ArrayList<>();



    public Board(int height, int width) {
        board = new GameObject[height][width];
    }

    public void addObjectToTable(GameObject gameObject) {
        board[gameObject.getCoord().getX()][gameObject.getCoord().getY()] = gameObject;
    }

   public GameObject getGameObjectByCoordinates(Coordinates moveCoordinates) {
        return board[moveCoordinates.getX()][moveCoordinates.getY()];
   }

<<<<<<< HEAD
        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        this.obstacles.add(wall3);
        this.obstacles.add(wall4);

        addObjectToTable(wall1);
        addObjectToTable(wall2);
        addObjectToTable(wall3);
        addObjectToTable(wall4);
    }

    public void createItems() {

        Item toiletPaper = new ItemToCollect(1,1,"toilet paper", " &", new Coordinates(7, 5));
        Item gel = new ItemToCollect(1, 1,"antibacterial gel", " %", new Coordinates(3, 2));
        Item gloves = new ItemToCollect(1, 1,"gloves", " !", new Coordinates(6, 2));
        Item mask = new ItemToCollect(1, 1, "mask", " $", new Coordinates(5, 7));

        items.add(toiletPaper);
        items.add(gel);
        items.add(gloves);
        items.add(mask);

        addObjectToTable(toiletPaper);
        addObjectToTable(gel);
        addObjectToTable(gloves);
        addObjectToTable(mask);

    }
=======
   public boolean checkIfObstacle(GameObject foundGameObject) {
        return obstacles.contains(foundGameObject);
   }
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (GameObject[] row : board) {
            for (GameObject column : row) {
                if (column != null) {
                    sb.append(column);
                }
                else {
                    sb.append(" .");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public GameObject[][] getBoard() {
        return board;
    }

    public List<Item> getItems() {
        return items;
    }

<<<<<<< HEAD
    public ArrayList<Item> getItems() {
        return items;
    }
=======
    public void addObjectToObstacles(Obstacle obstacle) {this.obstacles.add(obstacle);}
    public void addItemToItems(Item item) {this.items.add(item);}
>>>>>>> 02e5d8cd3b58b60e62246d719aa624ba3a52726b
}
