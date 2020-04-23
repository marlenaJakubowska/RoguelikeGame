package com.codecool.roguelike;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Game extends KeyAdapter {

    private Board board = new Board(20, 20);
    private Player player = new Player(new Coordinates(5, 5));


    public Game() {
        init();
    }

    private void init() {
        board.createObstacles();
        board.createItems();
        this.board.addObjectToTable(player);
    }

    public static void runGame() {
        JTextField textField = new JTextField();

        textField.addKeyListener(new Game());
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                if (canPlayerMove(Coordinates.w)) {
                    player.move(Coordinates.w, board);
                }
                break;
            case 's':
                if (canPlayerMove(Coordinates.s)) {
                    player.move(Coordinates.s, board);
                }
                break;
            case 'a':
                if (canPlayerMove(Coordinates.a)) {
                    player.move(Coordinates.a, board);
                }
                break;
            case 'd':
                if (canPlayerMove(Coordinates.d)) {
                    player.move(Coordinates.d, board);
                }
                break;
        }
        System.out.println(player.getCoord().toString());
        printBoard();
    }


    private void printBoard() {
        Engine.clearScreen();
        System.out.println(board);
    }

    public boolean canPlayerMove(Coordinates coord) {

        for (Obstacle obstacle : board.getObstacle()) {
            Coordinates pivot = obstacle.getCoord();
            if (isPlayerInRange(obstacle, coord)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPlayerInRange(Obstacle obstacle, Coordinates coord) {
        int width = obstacle.getWidth();
        int height = obstacle.getHeight();
        Coordinates pivot = obstacle.getCoord();
        int x = this.player.getCoord().getX() + coord.getX();
        int y = this.player.getCoord().getY() + coord.getY();

        return x >= pivot.getX() && x < pivot.getX()+height
                && y >= pivot.getY() && y < pivot.getY()+width;
    }
}
/*
-item -inventory
-remove from inventory
-inventory obok mapy
-weapon-spray antybakteryjny
-food-bakłażan
 */