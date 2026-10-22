package com.memegame.memepicsgame;


public class Meme {
    private String answer, ansDialg, theme, picPaths[];
    public static final int MAX_LETTERS = 10;
    private boolean solved = false;
    public Meme(String answer, String theme, String[] picPaths, String ansDialg){
        if (answer.length() < 3 || answer.length() > MAX_LETTERS) {
            throw new IllegalArgumentException("Answer must be 3 to " + MAX_LETTERS + " letters: " + answer);
        }
        this.ansDialg = ansDialg;
        this.answer = answer;
        this.theme = theme;
        this.picPaths = picPaths;
    }
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
        return first.substring(0, first.lastIndexOf('/')) + "/answer.png";
    }
    public String getId(){
        String first = picPaths[0];
        return first.substring(0, first.lastIndexOf('/'));
    }
    public void markSolved() {solved = true;}
}
