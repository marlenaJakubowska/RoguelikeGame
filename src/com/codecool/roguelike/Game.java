package com.codecool.roguelike;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {

    private final char UP = 'w';
    private final char DOWN = 's';
    private final char LEFT = 'a';
    private final char RIGHT = 'd';

    private Board board = new Board(20, 20);
    private Player player = new Player(new Coordinates(5, 5));
    private Engine engine = new Engine();
    private  Enemy enemy = new Enemy(new Coordinates(7,7));
    private UI ui = new UI();


    public Game() {
        init();
    }

    private void init() {
        board.getItems();

        engine.createWalls(board);
        engine.createForest(board);
        engine.createItems(board);
        this.board.addObjectToTable(player);
        this.board.addObjectToTable(enemy);
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
        char userInput = event.getKeyChar();
        switch (userInput) {
            case UP:
                if (canMoveInDirection(Coordinates.UP)) {
                    moveInDirection(Coordinates.UP);
                }
                break;
            case DOWN:
                if (canMoveInDirection(Coordinates.DOWN)) {
                    moveInDirection(Coordinates.DOWN);
                }
                break;
            case LEFT:
                if (canMoveInDirection(Coordinates.LEFT)) {
                    moveInDirection(Coordinates.LEFT);
                }
                break;
            case RIGHT:
                if (canMoveInDirection(Coordinates.RIGHT)) {
                    moveInDirection(Coordinates.RIGHT);
                }
                break;
        }
        // for enemy in enemies
        // enemy.move();

        ui.printBoard(board);
        player.printInventory();
    }

    private void moveInDirection(Coordinates coordinates) {
        player.move(coordinates, board);
    }

    private boolean canMoveInDirection(Coordinates up) {
        return !engine.isObstacle((up), player, board);
    }

}
