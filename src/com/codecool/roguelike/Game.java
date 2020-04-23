package com.codecool.roguelike;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Game extends KeyAdapter {

    private Board board = new Board(20, 20);
    private Player player = new Player(new Coordinates(5, 5));
    public Engine engine = new Engine();
    private  Enemy enemy = new Enemy(new Coordinates(7,7));

    public Game() {
        init();
    }

    private void init() {

        engine.createWalls(board);
        board.createItems();
        this.board.addObjectToTable(player);
        this.board.addObjectToTable(enemy);
        board.getItems();
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

        switch (ch) {
            case 'w':
                if (!isObstacle(Coordinates.w)) {
                    player.move(Coordinates.w, board);
                    enemy.move(Coordinates.w, board);
                }
                break;
            case 's':
                if (!isObstacle(Coordinates.s)) {
                    player.move(Coordinates.s, board);
                    enemy.move(Coordinates.s, board);
                }
                break;
            case 'a':
                if (!isObstacle(Coordinates.a)) {
                    player.move(Coordinates.a, board);
                    enemy.move(Coordinates.a, board);
                }
                break;
            case 'd':
                if (!isObstacle(Coordinates.d)) {
                    player.move(Coordinates.d, board);
                    enemy.move(Coordinates.d, board);
                }
                break;
        }
        printBoard();
    }

    private void printBoard() {
        engine.clearScreen();
        System.out.println(board);
    }

    public boolean isObstacle(Coordinates direction) {
        Coordinates toMoveCoordinates = player.toMoveCoordinates(direction);
        GameObject foundGameObject = board.getGameObjectByCoordinates(toMoveCoordinates);
        return board.checkIfObstacle(foundGameObject);
    }
}
