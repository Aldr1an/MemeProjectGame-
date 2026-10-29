package com.memegame.memepicsgame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Saves and loads the player's progress using a plain text file.
 * The file has one line saying which theme the player is on
 * ("current=1", for example), followed by one line for every solved
 * meme, which is just that meme's folder path from link Meme#getId().
 * Everything is static, so there's no need to create a SaveManager object.
 */
public class SaveManager {

    /** The save file. It has no folder in its path, so it sits in the folder the game is run from. */
    private static final Path FILE = Paths.get("save.txt");

    /**
     * Writes the current progress to save.txt: the current theme and the
     * ID of every solved meme. Each save replaces the whole old file.
     * If the file can't be written, a message is printed to the console
     * and the game carries on.
     */
    public static void save() {
        List<String> lines = new ArrayList<>();
        lines.add("current=" + GameData.currentTheme);
        for (Theme t : GameData.THEMES) {
            for (Meme m : t.getMemes()) {
                if (m.isSolved()) {
                    lines.add(m.getId());
                }
            }
        }
        try {
            Files.write(FILE, lines);
        } catch (IOException e) {
            System.out.println("Could not save: BUDDYBOI ALSO I DDNT WRITE THIS SHIT THIS IS API" + e.getMessage());
        }
    }

 /**
     * Reads save.txt and restores the saved progress: sets the current
     * theme and marks every saved meme as solved. If there's no save
     * file yet (a brand new game), nothing happens. If the file can't
     * be read, a message is printed to the console and the game starts
     * with no progress restored.
     * <p>
     * Call this once when the game starts, after {@link GameData} has
     * built its themes, since it needs the memes to exist so it can
     * match them against the saved IDs.
     */
    public static void load() {
        if (!Files.exists(FILE)) {
            return;
        }
        try {
            List<String> lines = Files.readAllLines(FILE);
            for (String line : lines) {
                if (line.startsWith("current=")) {
                    GameData.currentTheme = Integer.parseInt(line.substring(8));
                }
            }
            for (Theme t : GameData.THEMES) {
                for (Meme m : t.getMemes()) {
                    if (lines.contains(m.getId())) {
                        m.markSolved();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load: " + e.getMessage());
        }

    }
}
