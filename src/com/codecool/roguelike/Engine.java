package com.codecool.roguelike;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {

    private final List<Item> itemToLoop = new ArrayList<>();

    public void addItemToItemToLoop(Item newItem) {this.itemToLoop.add(newItem);}

    public void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createWalls(Board board) {
        placeWall(new Coordinates(0, 0), new Coordinates(0, 19), board);
        placeWall(new Coordinates(0, 0), new Coordinates(19, 0), board);
        placeWall(new Coordinates(19, 0), new Coordinates(19, 19), board);
        placeWall(new Coordinates(0, 19), new Coordinates(19, 19), board);
    }

    public void placeWall(Coordinates origin, Coordinates end, Board board) {
        for (int x = origin.getX(); x <= end.getX(); x++) {
            for (int y = origin.getY(); y <= end.getY(); y++) {
                Coordinates pivot = new Coordinates(x, y);
                Obstacle obstacle = new Obstacle(pivot, " #");
                placeObstacleInGameWorld(board, obstacle);
            }
        }
    }

    private void placeObstacleInGameWorld(Board board, Obstacle obstacle) {
        board.addObjectToObstacles(obstacle);
        board.addObjectToTable(obstacle);
    }

    public void createForest(Board board) {
        ThreadLocalRandom current = ThreadLocalRandom.current();

        for (int i = 0; i < 100; i++) {
            int x = current.nextInt(18) + 1;
            int y = current.nextInt(18) + 1;
            Obstacle tree = new Obstacle(new Coordinates(x, y), " T");
            placeObstacleInGameWorld(board, tree);
        }
    }

    public boolean isObstacle(Coordinates direction, Player player, Board board) {
        Coordinates toMoveCoordinates = player.toMoveCoordinates(direction);
        GameObject foundGameObject = board.getGameObjectByCoordinates(toMoveCoordinates);
        return board.checkIfObstacle(foundGameObject);
    }

    public void createItems(Board board) {
        for (int i = 0; i < 20; i++) {
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

