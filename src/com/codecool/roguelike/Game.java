package com.codecool.roguelike;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Game extends KeyAdapter {

    private Board board = new Board(20, 20);
    private Player player = new Player(new Coordinates(5, 5));
    private Engine engine = new Engine();
    private  Enemy enemy = new Enemy(new Coordinates(7,7));
    private Ui ui = new Ui();


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

        char ch = event.getKeyChar();

        switch (ch) {
            case 'w':
                if (!engine.isObstacle((Coordinates.w), player, board)) {
                    player.move(Coordinates.w, board);
                }
                break;
            case 's':
                if (!engine.isObstacle((Coordinates.s), player, board)) {
                    player.move(Coordinates.s, board);
                }
                break;
            case 'a':
                if (!engine.isObstacle((Coordinates.a), player, board)) {
                    player.move(Coordinates.a, board);
                }
                break;
            case 'd':
                if (!engine.isObstacle((Coordinates.d), player, board)) {
                    player.move(Coordinates.d, board);
                }
                break;
        }
        ui.printBoard(board);
        player.addToInventory(board.getItems().toString());
    }

}
