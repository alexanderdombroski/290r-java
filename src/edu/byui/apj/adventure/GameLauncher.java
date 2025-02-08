package edu.byui.apj.adventure;

public class GameLauncher {
    private GameLauncher() {}

    public static void main(String[] args) {
        Game.getInstance().start();
    }
}
