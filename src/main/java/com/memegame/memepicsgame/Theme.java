package com.memegame.memepicsgame;

import java.util.ArrayList;
import java.util.Random;

public class Theme {
    //Fields
    private String name;
    private ArrayList<Meme> memes = new ArrayList<>();
    private int requiredToUnlockNext;
    //Constructor
    public Theme(String name, int requiredToUnlock){
        this.name = name;
        this.requiredToUnlockNext = requiredToUnlock;
    }
    //Getters
    public void addMeme(Meme m) {memes.add(m);}
    public String getName(){return name;}
    public ArrayList<Meme> getMemes() { return memes; }
    //Solved meme Counter whadda ya know
    public int getSolvedCount(){
        int count = 0;
        for (Meme m : memes){
            if (m.isSolved()) count++;
        }
        return count;
    }
    public boolean isNextUnlocked(){
        return getSolvedCount() >= requiredToUnlockNext;
    }
    public int getProgressPercent(){
        if (memes.isEmpty()) return 0; //dividsion by 0 is no good safeguard to it is to predict it
        return getSolvedCount() * 100 / memes.size();
    }
    public Meme getRandomUnsolved(){
        ArrayList<Meme> left = new ArrayList<>();
        for (Meme m : memes) {
            if (!m.isSolved()) left.add(m);
        }
        if (left.isEmpty()) return null;
        return left.get(new Random().nextInt(left.size()));
    }
    
    
}
