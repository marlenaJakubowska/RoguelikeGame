package com.codecool.roguelike;

import java.util.Scanner;


public class Menu {

    private Scanner scanner = new Scanner(System.in);
    public Ui print = new Ui();
    
    public void startMenu() {
        boolean isRunning = true;
        while(isRunning) {
            this.print.printMainMenu();
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
                    print.printAbout();
                    break;
                }
                case 0: {
                    isRunning = false;
                }
            }
        }
    }
}
