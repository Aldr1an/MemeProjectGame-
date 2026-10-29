package com.memegame.memepicsgame;

import java.util.ArrayList;
import java.util.Random;

/**
 * A group of memes that share a topic, like "postcovid", plus the rule for
 * unlocking the next topic. The game keeps its themes in order in
 * {@link GameData}, and each theme holds the /Meme/ objects that
 * belong to it.
 * A Theme "has" Memes (composition). It never changes whether a meme is
 * solved, it only reads the flag to work out progress.
 */
public class Theme {

    // Fields
    private String name;
    /** Every meme in this theme, solved or not. */
    private ArrayList<Meme> memes = new ArrayList<>();
    private int requiredToUnlockNext;

    // Constructor
    /**
     * Creates an empty theme. Memes are added afterwards via .addMeme(Meme).
     *
     * @param name             the theme's name (also its folder name)
     * @param requiredToUnlock number of solved memes needed to unlock the next theme
     */
    public Theme(String name, int requiredToUnlock){
        this.name = name;
        this.requiredToUnlockNext = requiredToUnlock;
    }

    // Adder and getters
    /**  Adds a meme to this theme.*/
    public void addMeme(Meme m) {memes.add(m);}

    /** @return the theme's name */
    public String getName(){return name;}

    /** @return the list of all memes in this theme */
    public ArrayList<Meme> getMemes() { return memes; }

    /**
     * Counts how many memes in this theme the player has solved.
     *
     * @return the number of solved memes, from 0 up to the total
     */
    public int getSolvedCount(){
        int count = 0;
        for (Meme m : memes){
            if (m.isSolved()) count++;
        }
        return count;
    }

    /**
     * Checks whether the player has solved enough memes here to unlock the
     * theme that comes after this one.
     *
     * @return true if the solved count reaches the required number
     */
    public boolean isNextUnlocked(){
        return getSolvedCount() >= requiredToUnlockNext;
    }

    /**
     * Works out progress for the theme's progress bar.
     *
     * @return solved memes as a whole-number percentage (0 to 100);
     *         returns 0 for an empty theme to avoid dividing by zero
     */
    public int getProgressPercent(){
        if (memes.isEmpty()) return 0; // division by zero would crash, so guard against it
        return getSolvedCount() * 100 / memes.size();
    }

    /**
     * Picks a random meme the player hasn't solved yet. Solved memes are never
     * picked, so the player doesn't see the same meme twice.
     *
     * @return a random unsolved meme, or {@code null} if every meme is solved
     *         (meaning the theme is finished)
     */
    public Meme getRandomUnsolved(){
        ArrayList<Meme> left = new ArrayList<>();
        for (Meme m : memes) {
            if (!m.isSolved()) left.add(m);
        }
        if (left.isEmpty()) return null;
        return left.get(new Random().nextInt(left.size()));
    }
}