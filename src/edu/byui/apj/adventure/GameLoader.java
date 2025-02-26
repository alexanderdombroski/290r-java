package edu.byui.apj.adventure;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

public class GameLoader {
    private GameLoader() {}

    /**
    * Reads a player object in from a file
     */
    public static Optional<Player> loadPlayer() {
        try (FileInputStream fileIn = new FileInputStream("game.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return Optional.of((Player) in.readObject());
        } catch ( ClassNotFoundException | IOException e) {
            System.err.println("Error loading player: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static void savePlayer(Player player) {
        try (FileOutputStream fileOut = new FileOutputStream("game.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(player);
            System.out.println(TerminalUtils.Ansi.colorGreen("Your game was saved successfully."));
        } catch (IOException i) {
            System.err.println("Error saving player: " + i.getMessage());
        }
    }

    public static void showMessage(String filename, String defaultMessage) {
        try {
            URL url = new URL("https://qrbriggs-byui.github.io/apj-files/adventure/" + filename);
            URLConnection connection = url.openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println(defaultMessage);
        }

    }
}
