package com.codecool.roguelike;

import java.util.ArrayList;

public class Ui {

    private Engine engine = new Engine();

    public void printMainMenu() {
        System.out.println("Welcome to Covid In The Forest Game. Please choose an option:");
        System.out.println("1. New Game");
        System.out.println("2. HighScores");
        System.out.println("3. About");
        System.out.println("0. Exit");
    }

    public void printAbout() {
        System.out.println("Merging around:");
        System.out.println("    Dominika");
        System.out.println("    Artur");
        System.out.println("    Marlena");
    }

    public void printBoard(Board board) {
        engine.clearScreen();
        System.out.println(board);
    }
}
