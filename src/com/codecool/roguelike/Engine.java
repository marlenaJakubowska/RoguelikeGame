package com.codecool.roguelike;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engine {

    private List<Obstacle> obstacleToLoop = new ArrayList<>();
    public void addObstacleToObstacleToLoop(Obstacle newObstacle) {this.obstacleToLoop.add(newObstacle);}
    private List<Item> itemToLoop = new ArrayList<>();
    public void addItemToItemToLoop(Item newItem) {this.itemToLoop.add(newItem);}

    public void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createWalls(Board board) {
        for(int i = 0; i <20; i++) {
            Obstacle wall1 = new Obstacle(new Coordinates(0, i), " #");
            Obstacle wall2 = new Obstacle(new Coordinates(19, i), " #");
            Obstacle wall3 = new Obstacle(new Coordinates(i, 0), " #");
            Obstacle wall4 = new Obstacle(new Coordinates(i, 19), " #");

            addObstacleToObstacleToLoop(wall1);
            addObstacleToObstacleToLoop(wall2);
            addObstacleToObstacleToLoop(wall3);
            addObstacleToObstacleToLoop(wall4);

        }
        for (Obstacle obstacle : obstacleToLoop) {
            board.addObjectToObstacles(obstacle);
            board.addObjectToTable(obstacle);
        }
    }

    public void createForest(Board board) {
        Random rand = new Random();

        for(int i = 0; i < 100; i++) {
            int x = rand.nextInt(18) +1;
            int y = rand.nextInt(18) +1;
            Obstacle tree = new Obstacle(new Coordinates(x, y), " T");
            board.addObjectToObstacles(tree);
            board.addObjectToTable(tree);
        }
    }

    public boolean isObstacle(Coordinates direction, Player player, Board board) {
        Coordinates toMoveCoordinates = player.toMoveCoordinates(direction);
        GameObject foundGameObject = board.getGameObjectByCoordinates(toMoveCoordinates);
        return board.checkIfObstacle(foundGameObject);
    }

    public void createItems(Board board) {
        for(int i = 0; i <20; i++) {
            Item item1 = new ItemToCollect("toilet paper", " &", new Coordinates(7, 5));
            Item item2 = new ItemToCollect("antibacterial gel", " %", new Coordinates(3, 2));
            Item item3 = new ItemToCollect("gloves", " !", new Coordinates(6, 2));
            Item item4 = new ItemToCollect("mask", " $", new Coordinates(5, 7));

            addItemToItemToLoop(item1);
            addItemToItemToLoop(item2);
            addItemToItemToLoop(item3);
            addItemToItemToLoop(item4);

        }
        for (Item item : itemToLoop) {
            board.addItemToItems(item);
            board.addObjectToTable(item);
        }
    }
}

