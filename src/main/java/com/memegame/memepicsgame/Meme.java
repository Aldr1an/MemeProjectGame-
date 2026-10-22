package com.memegame.memepicsgame;


public class Meme {
    private String answer, ansDialg, answerOrig, theme, picPaths[];
    public static final int MAX_LETTERS = 11;
    private boolean solved = false;
    public Meme(String answer, String theme, String[] picPaths, String ansDialg){

        if (answer.length() < 3 || answer.length() > MAX_LETTERS) {
            throw new IllegalArgumentException("Answer must be 3 to " + MAX_LETTERS + " letters: " + answer);
        }
        this.ansDialg = ansDialg;
        this.answerOrig = answer;
        this.answer = answer.replaceAll("[!?\\s]+", "");
        this.theme = theme;
        this.picPaths = picPaths;
    }
    public String captureAnswerOrig(){ return answerOrig;}
    public String getAnswer() { return answer; }
    public String getTheme() { return theme; }
    public String[] getPicPaths(){ return picPaths; }
    public String getAnswerDialg() {return ansDialg;}
    public boolean checkAnswer(String guess){
        if(guess.trim().equalsIgnoreCase(answer)){
            solved = true;
            return true;
        }
        return false;
    }
    public boolean isSolved(){
        return solved;
    }
    public String getRevealPath() {
        String first = picPaths[0];
        String address = first.substring(0, first.lastIndexOf('/'));
        String pngPath = address + "/answer.png";
        String gifPath = address + "/answer.gif";
        String vidPath = address + "/answer.mp4";
        if (getClass().getResource(pngPath) != null){
            return pngPath;
        }
        if(getClass().getResource(gifPath) != null){
            return gifPath;
        }
        if(getClass().getResource(vidPath) != null){
            return vidPath;
        }
        return null;
    }
    public String getId(){
        String first = picPaths[0];
        return first.substring(0, first.lastIndexOf('/'));
    }
    public void markSolved() {solved = true;}
}
