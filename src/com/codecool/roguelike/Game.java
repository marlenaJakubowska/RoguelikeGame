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

        engine.createWallsFor(board);
        board.createItems();
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

        System.out.println((int) ch);

        switch (ch) {
            case 'w':
                if (!cantPlayerMove(Coordinates.w)) {
                    player.move(Coordinates.w, board);
                    enemy.move(Coordinates.w, board);
                }
                break;
            case 's':
                if (!cantPlayerMove(Coordinates.s)) {
                    player.move(Coordinates.s, board);
                    enemy.move(Coordinates.s, board);
                }
                break;
            case 'a':
                if (!cantPlayerMove(Coordinates.a)) {
                    player.move(Coordinates.a, board);
                    enemy.move(Coordinates.a, board);
                }
                break;
            case 'd':
                if (!cantPlayerMove(Coordinates.d)) {
                    player.move(Coordinates.d, board);
                    enemy.move(Coordinates.d, board);
                }
                break;
        }
        System.out.println(player.getCoord().toString());
        printBoard();
    }

    private void printBoard() {
        engine.clearScreen();
        System.out.println(board);
    }

    public boolean cantPlayerMove(Coordinates direction) {
        Coordinates toMoveCoordinates = player.toMoveCoordinates(direction);
        GameObject foundGameObject = board.getGameObjectByCoordinates(toMoveCoordinates);
        return board.checkIfObstacle(foundGameObject);
    }
}
