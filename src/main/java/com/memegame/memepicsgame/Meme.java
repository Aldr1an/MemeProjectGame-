package com.memegame.memepicsgame;

/**
 * One meme puzzle in the game. A Meme holds the four clue pictures,
 * the answer the player has to guess, the name of the meme Iconic lines of it could be either.
 * 
 * It should remember if the the player has solved it yet.
 */
public class Meme {

    /** The most letters an answer can have (spaces and punctuation don't count). */
    public static final int MAX_LETTERS = 11;

    /** The answer with spaces and punctuation removed, used for checking guesses. */
    private String answer;

    /** The answer exactly as it was written, used for displaying it nicely. */
    private String answerOrig;

    /** The text shown in the congrats pop-up after solving. */
    private String ansDialg;

    /** The theme this meme belongs to, like "postcovid", "covid", etc... */
    private String theme;

    /** Resource paths of the four clue pictures, in order. */
    private String[] picPaths;

    /** True once the player has solved this meme. */
    private boolean solved = false;

    /**
     * Creates a meme puzzle. The answer is stored twice: once as written
     * (for display) and once with commas, "!", "?" and spaces stripped out
     * (for checking guesses).
     *
     * @param answer   the answer, e.g. "Rene Bullet"
     * @param theme    the theme folder name, e.g. "postcovid"
     * @param picPaths the resource paths of the four clue pictures
     * @param ansDialg the dialogue shown when the meme is solved
     * @throws IllegalArgumentException if the cleaned-up answer is shorter
     *         than 3 letters or longer than {@link #MAX_LETTERS}
     */
    public Meme(String answer, String theme, String[] picPaths, String ansDialg) {
        this.ansDialg = ansDialg;
        this.answerOrig = answer;
        this.answer = answer.replaceAll("[,!?\\s]+", "");
        this.theme = theme;
        this.picPaths = picPaths;
        if (this.answer.length() < 3 || this.answer.length() > MAX_LETTERS) {
            throw new IllegalArgumentException("Answer must be 3 to " + MAX_LETTERS + " letters: " + answer);
        }
    }

    /**
     * Gives the answer exactly as it was originally written,
     * with its spaces and punctuation.
     *
     * @return the ORIGINAL answer text
     */
    public String captureAnswerOrig() { return answerOrig; }

    /**
     * Gives the cleaned-up answer used for the letter tiles and checking.
     *
     * @return the answer WITHOUT spaces or punctuation
     */
    public String getAnswer() { return answer; }

    public String getTheme() { return theme; }

    /** @return the resource paths of the four clue pictures */
    public String[] getPicPaths() { return picPaths; }

    /** @return the dialogue shown in the congrats pop-up */
    public String getAnswerDialg() { return ansDialg; }

    /**
     * Checks a player's guess against the answer, ignoring capital
     * letters and extra spaces at the ends. A correct guess also marks
     * this meme as solved.
     *
     * @param guess what the player entered
     * @return true if the guess is correct, false otherwise
     */
    public boolean checkAnswer(String guess) {
        if (guess.trim().equalsIgnoreCase(answer)) {
            solved = true;
            return true;
        }
        return false;
    }

    /** @return true if the player has already solved this meme */
    public boolean isSolved() {
        return solved;
    }

    /**
     * Finds the picture shown in the congrats pop-up. It looks in the
     * same folder as the clue pictures for answer.png, then answer.jpg,
     * then answer.gif, and uses the first one that exists.
     *
     * @return the resource path of the reveal picture, or null if the
     *         folder has no answer picture
     */
    public String getRevealPath() {
        String first = picPaths[0];
        String address = first.substring(0, first.lastIndexOf('/'));
        String pngPath = address + "/answer.png";
        String jpgPath = address + "/answer.jpg";
        String gifPath = address + "/answer.gif";
        if (getClass().getResource(pngPath) != null) {
            return pngPath;
        }
        if (getClass().getResource(jpgPath) != null) {
            return jpgPath;
        }
        if (getClass().getResource(gifPath) != null) {
            return gifPath;
        }
        return null;
    }

    /**
     * Gives a unique ID for this meme, which is just the path of its
     * folder (the clue pictures' path without the file name).
     * Handy for telling memes apart, like when saving progress.
     *
     * @return the meme's folder path, e.g. "/memes/postcovid/meme01"
     */
    public String getId() {
        String first = picPaths[0];
        return first.substring(0, first.lastIndexOf('/'));
    }

    /**
     * Marks this meme as solved without needing a guess, such as when
     * restoring saved progress.
     */
    public void markSolved() { solved = true; }
}