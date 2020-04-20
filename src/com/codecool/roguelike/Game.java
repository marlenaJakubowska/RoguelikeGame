package com.codecool.roguelike;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Game extends KeyAdapter {

    private Player player;
    private final int width = 20;
    private final int height = 20;
    private ArrayList<Obstacle> obstacles;


    public Game() {
        player = new Player();
        obstacles = new ArrayList<>();
        createObstacles();
    }

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                if (canPlayerMove(Coordinates.w)) {
                    player.move(Coordinates.w);
                }
                break;
            case 's':
                if (canPlayerMove(Coordinates.s)) {
                    player.move(Coordinates.s);
                }
                break;
            case 'a':
                if (canPlayerMove(Coordinates.a)) {
                    player.move(Coordinates.a);
                }
                break;
            case 'd':
                if (canPlayerMove(Coordinates.d)) {
                    player.move(Coordinates.d);
                }
                break;
        }
        System.out.println(player.getCoord().toString());
        printBoard();
    }

    private void createObstacles() {
        Obstacle wall1  = new Obstacle(new Coordinates(0, 0), width, 1, " #");
        Obstacle wall2 = new Obstacle(new Coordinates(0,0), 1, height, "#");
        Obstacle wall3 = new Obstacle(new Coordinates(19, 0), width, 1, "# ");
        Obstacle wall4 = new Obstacle(new Coordinates(0, 19), 1, height-1, " #");
        this.obstacles.add(wall1);
        this.obstacles.add(wall2);
        this.obstacles.add(wall3);
        this.obstacles.add(wall4);

    }

    private void printBoard() {
        clearScreen();
        String[][] board  = new String[width][height];
        board[this.player.getCoord().getX()][this.player.getCoord().getY()] = player.getSymbol();

        printObstacles(board);

        for(int i = 0; i< width;  i++) {
            for(int j = 0; j< height; j++) {
                if(board[i][j] != null) {
                    System.out.print(board[i][j]);
                    continue;
                }
                System.out.print(" .");
            }
            System.out.println();
        }
    }

    public void printObstacles(String[][] board) {
        for (Obstacle obstacle : obstacles) {
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();
            Coordinates pivot = obstacle.getPivot();

            for (int i = pivot.getX(); i < pivot.getX()+height; i++) {
                for(int j = pivot.getY(); j < pivot.getY()+width;j++) {
                    board[i][j] = obstacle.getSymbol();
                }
            }
        }
    }

    public boolean canPlayerMove(Coordinates coord) {

        for (Obstacle obstacle :obstacles) {
            Coordinates pivot = obstacle.getPivot();

            if (isPlayerInRange(obstacle, coord)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPlayerInRange(Obstacle obstacle, Coordinates coord) {
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getPivot();
        int x = this.player.getCoord().getX() + coord.getX();
        int y = this.player.getCoord().getY() + coord.getY();

        return x >= pivot.getX() && x < pivot.getX()+height
                && y >= pivot.getY() && y < pivot.getY()+width;
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}


