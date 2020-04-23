package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.Random;

public class Engine {



    public void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createWalls(Board board) {
        for(int i = 0; i <20; i++) {
            Obstacle wallObject1 = new Obstacle(new Coordinates(0, i), " #");
            Obstacle wallObject2 = new Obstacle(new Coordinates(19, i), " #");
            Obstacle wallObject3 = new Obstacle(new Coordinates(i, 0), " #");
            Obstacle wallObject4 = new Obstacle(new Coordinates(i, 19), " #");
            board.addObjectToObstacles(wallObject1);
            board.addObjectToObstacles(wallObject2);
            board.addObjectToObstacles(wallObject3);
            board.addObjectToObstacles(wallObject4);

            board.addObjectToTable(wallObject1);
            board.addObjectToTable(wallObject2);
            board.addObjectToTable(wallObject3);
            board.addObjectToTable(wallObject4);

        }
    }

    public void createForest(Board board) {
        Random rand = new Random();

        for(int i = 0; i < 100; i++) {
            int x = rand.nextInt(18) +1;
            int y = rand.nextInt(18) +1;
            Obstacle tree = new Obstacle(new Coordinates(x, y), " ♈");
            board.addObjectToObstacles(tree);
            board.addObjectToTable(tree);
        }
    }
}

