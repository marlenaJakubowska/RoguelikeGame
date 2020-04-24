package com.codecool.roguelike;

public class UI {

    private Engine engine = new Engine();

    public void printMainMenu() {
        System.out.println("Welcome to Covid In The Forest Game. Please choose an option:");
        System.out.println("1. New Game");
        System.out.println("2. HighScores");
        System.out.println("3. About");
        System.out.println("0. Exit");
    }

    public void printBoard(Board board) {
        engine.clearScreen();
        System.out.println(board);
    }

    public void printGameInfo() {
        System.out.println("\nSpring 2020, the world has fallen. New virus has spread across countries. \n"
                + "You as a survivor need supplies. Your goal is to collect them from forest\n"
                + "WATCH OUT FOR ENEMIES\n"
                + "\nDevelopers:\n"
                + "Dominika Jarek\n"
                + "Artur Jakubowski\n"
                + "Marlena Jakubowska\n");
    }
}
