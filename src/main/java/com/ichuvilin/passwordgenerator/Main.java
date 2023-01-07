package com.ichuvilin.passwordgenerator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                new Menu().mainMenu();
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}