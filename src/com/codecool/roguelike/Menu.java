package com.codecool.roguelike;

import java.util.Scanner;


public class Menu {

    public static Scanner scanner = new Scanner(System.in);
    
    public static void startMenu() {
        boolean isRunning = true;
        while(isRunning) {
            Ui.printMainMenu();
            int option = scanner.nextInt();

            switch(option) {
                case 1: {
                    Game.runGame();
                    isRunning = false;
                    break;
                }

                case 2: {
                    System.out.println("Highscores - Work in progress");
                    break;
                }
                case 3: {
                    System.out.println("About - Work in progress");
                    break;
                }
                case 0: {
                    isRunning = false;
                }
            }
        }
    }
}
