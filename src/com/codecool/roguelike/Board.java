package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.List;

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

   public boolean checkIfObstacle(GameObject foundGameObject) {
        return obstacles.contains(foundGameObject);
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

    public List<Item> getItems() {
        return items;
    }

    public void addObjectToObstacles(Obstacle obstacle) {this.obstacles.add(obstacle);}
    public void addItemToItems(Item item) {this.items.add(item);}
}
