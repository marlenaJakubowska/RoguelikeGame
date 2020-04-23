package com.codecool.roguelike;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends GameObject {

    List<Integer> maxEnemyMovementRangeList = new ArrayList<>();

    public Enemy(Coordinates coordinates) {
        super(coordinates, " E");
    }

    public Coordinates getCoord() {
        return this.coord;
    }

    public void move(Coordinates enemyDirection, Board board) {
        board.getBoard()[this.coord.getX()][this.coord.getY()] = null;
        //System.out.println(enemyDirection.toString());
        int x = this.coord.getX() + enemyDirection.getX() + randomlySelectedMovementRange();
        int y = this.coord.getY() + enemyDirection.getY() + randomlySelectedMovementRange();
        //interact(board.getBoard()[x][y]);
        this.coord = new Coordinates(x, y);
        board.getBoard()[this.coord.getX()][this.coord.getY()] = this;

    }

    private void addEnemyMovementRange(){
        maxEnemyMovementRangeList.add(-1);
        maxEnemyMovementRangeList.add(0);
        maxEnemyMovementRangeList.add(1);
    }

    private Integer randomlySelectedMovementRange(){
        addEnemyMovementRange();
        Random randomRange = new Random();
        return maxEnemyMovementRangeList.get(randomRange.nextInt(maxEnemyMovementRangeList.size()));
    }
}
