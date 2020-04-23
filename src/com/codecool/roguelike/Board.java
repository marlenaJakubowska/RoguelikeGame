package com.codecool.roguelike;

import java.util.ArrayList;

public class Board {

    private int width;
    private int height;
    private GameObject[][] board;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Obstacle> obstacles = new ArrayList<>();



    public Board(int height, int width) {
        board = new GameObject[height][width];
    }

    public void addObjectToTable(GameObject gameObject) {
        board[gameObject.getCoord().getX()][gameObject.getCoord().getY()] = gameObject;
    }



   public GameObject getGameObjectByCoordinates(Coordinates moveCoordinates) {
        return board[moveCoordinates.getX()][moveCoordinates.getY()];

   }

   public boolean checkIfObstacle(GameObject foundGameObject) {
        return obstacles.contains(foundGameObject);
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

    public ArrayList<Obstacle> getObstacle() {
        return obstacles;
    }

    public int getHeight() {return this.height;}
    public int getWidth() {return this.width;}

    public void addObjectToObstacles(Obstacle obstacle) {this.obstacles.add(obstacle);}
}
