package com.memegame.memepicsgame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {

    private static final Path FILE = Paths.get("save.txt");

    public static void save() {
        List<String> lines = new ArrayList<>();
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

    public static void load() {
        if (!Files.exists(FILE)) {
            return;
        }
        try {
            List<String> lines = Files.readAllLines(FILE);
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
