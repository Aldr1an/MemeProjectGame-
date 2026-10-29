package com.memegame.memepicsgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The game's data hub. It builds every theme and its memes once when the
 * game starts, and keeps them in one place so any screen can use them.
 * Also has helpers for building memes and checking which themes are unlocked.
 */
public class GameData{
    
    /** Every theme in the game, in play order: postcovid, covid, then precovid. */    
    private static final ArrayList<Theme> THEMES = new ArrayList<>();
    
     /** Index (in {@link #THEMES}) of the theme the player is currently on. */
    private static int currentTheme = 0;
    
    // Static block: runs once, automatically, the first time GameData is used.
    // It creates the three themes, fills each with its 15 memes As AGREED UPON WITH THE BOYS  then adds
    // them to THEMES. To add a new meme, add one more addMeme line here
    static {
       Theme postcovid = new Theme("postcovid", 7);
       Theme covid     = new Theme("covid", 9);
       Theme precovid  = new Theme("precovid", 13);
       //postCovid
       postcovid.addMeme(makeMeme("postcovid", "meme01", "BOBET", "Mr.MVP himself"));
       postcovid.addMeme(makeMeme("postcovid", "meme02", "CLOWNS!", "This Gov is Circus"));
       postcovid.addMeme(makeMeme("postcovid", "meme03", "BOY DILA", "Tradionalized Harrasment"));
       postcovid.addMeme(makeMeme("postcovid", "meme04", "ALICE  GUO", "Send Alice Guo Baddie pics"));
       postcovid.addMeme(makeMeme("postcovid", "meme05", "JB SUAREZ", "HAHAHAH DI KO ALAM SASABHIN LT"));
       postcovid.addMeme(makeMeme("postcovid", "meme06", "BILISAN MO!", "BILISAN MO!!!!!!!!!!!"));
       postcovid.addMeme(makeMeme("postcovid", "meme07", "DiWATA", "DUMARAMI NA-"));
       postcovid.addMeme(makeMeme("postcovid", "meme08", "BURST FADE?", "BURSTFADE YAN YAH? - BURSTFADE YAN"));
       postcovid.addMeme(makeMeme("postcovid", "meme09", "TITIKMAN", "ALJUR ALVARES?"));
       postcovid.addMeme(makeMeme("postcovid", "meme10", "ALDEN", "IDK I don't watch tv man"));
       postcovid.addMeme(makeMeme("postcovid", "meme11", "ESMERINGHOY", "Esmeringhoy muna bago mag hiwalay"));
       postcovid.addMeme(makeMeme("postcovid", "meme12", "SENATE RUN", "RUN LIKE THE WIND BATO!"));
       postcovid.addMeme(makeMeme("postcovid", "meme13", "WALA HELMET", "MALI MO PARE!"));
       postcovid.addMeme(makeMeme("postcovid", "meme14", "NENENG B", "MAAAA? ANO ULAM?"));
       postcovid.addMeme(makeMeme("postcovid", "meme15", "SOPHIE PRIME", "YOOHOO, DITO ANG TINGIN"));
       
       //Covid
       covid.addMeme(makeMeme("covid", "meme01", "AH SARADO?", "Bili sana ako eh..."));
       covid.addMeme(makeMeme("covid", "meme02", "AKOSIRIZAL", "\"AKO ANG NAMATAY SAINYO!\""));
       covid.addMeme(makeMeme("covid", "meme03", "ALLEN KALBO", "\"SINO YUNG NAG A-ALEN KALBO?\""));
       covid.addMeme(makeMeme("covid", "meme04", "CALOOCAN BOY", "EH PAANO KUNG..."));
       covid.addMeme(makeMeme("covid", "meme05", "OTLUM", "Ang depinisyon ng magnanakaw"));
       covid.addMeme(makeMeme("covid", "meme06", "MASON AKO!", "\"OH?! SIGEEEEEE\""));
       covid.addMeme(makeMeme("covid", "meme07", "BUUNJA", "\"ANO'NG PARTE NG KATAWAN...\""));
       covid.addMeme(makeMeme("covid", "meme08", "GET DAT 30", "\"COME ON PATCH!\""));
       covid.addMeme(makeMeme("covid", "meme09", "MIKEY E", "\"ANG SARAP MO PIA\""));
       covid.addMeme(makeMeme("covid", "meme10", "COVID MASCOT", "NU YAN?"));
       covid.addMeme(makeMeme("covid", "meme11", "TYRONE TIAGA", "Yan nanaman..."));
       covid.addMeme(makeMeme("covid", "meme12", "TROPA TIME", "DARWIN AND PIPOY TROPATIME"));
       covid.addMeme(makeMeme("covid", "meme13", "WALASCROLAN", "PANOORIN NYO KAME!"));
       covid.addMeme(makeMeme("covid", "meme14", "NORMALIN", "\"UY UY UY? ANO YUN?\""));
       covid.addMeme(makeMeme("covid", "meme15", "KIM CHU", "\"AY PWEDE NA PALA LUMABAS\""));
       
       //Precovid
       precovid.addMeme(makeMeme("precovid", "meme01", "BULALORD", "Yung sinusupsop!"));
       precovid.addMeme(makeMeme("precovid", "meme02", "JONATHAN", "Dunk it!"));
       precovid.addMeme(makeMeme("precovid", "meme03", "DOTA", "Anong pipiliin mo?!"));
       precovid.addMeme(makeMeme("precovid", "meme04", "FINISH NA", "WALA NA!"));
       precovid.addMeme(makeMeme("precovid", "meme05", "TABE MAINET", "\"HARANG HARANG KA PA DYAN!\""));
       precovid.addMeme(makeMeme("precovid", "meme06", "NA STUCK", "ARAY KOH"));
       precovid.addMeme(makeMeme("precovid", "meme07", "ALING VICKY", "yung anak mo nahulog sa imburnal!!\""));
       precovid.addMeme(makeMeme("precovid", "meme08", "SEGS!", "Light\n's on? | Light\n's off?"));
       precovid.addMeme(makeMeme("precovid", "meme09", "GINAGAWA MO?!", "\"AGIK...\""));
       precovid.addMeme(makeMeme("precovid", "meme10", "TAPOS NA PO", "\"SIR,    TAPOS NA PO :>\""));
       precovid.addMeme(makeMeme("precovid", "meme11", "LISTEN, LOOK", "YEP IT\'S \"LISTEN, LOOK, LISTEN, LEARN\" "));
       precovid.addMeme(makeMeme("precovid", "meme12", "TAGURO", "TAPUSIN! TAPUSIN! TAPUSIN!"));
       precovid.addMeme(makeMeme("precovid", "meme13", "TITO BADANG", "\"DADDY DADDY SI TITO BADANG\""));
       precovid.addMeme(makeMeme("precovid", "meme14", "STAPH!", "Peak Rapbattle literal chills"));
       precovid.addMeme(makeMeme("precovid", "meme15", "LAKASAN MO!", "\"WAG MO SIGAWAN PARE\""));
       
       THEMES.add(postcovid);
       THEMES.add(covid);
       THEMES.add(precovid);
    }

    
    //GETTERS AND SETTERS :)
    public static int getCurrentTheme(){
        return currentTheme;
    }
    public static void setCurrentTheme(int index){
         currentTheme = index;
    }
    
    public static Theme getTheme(int index) { return THEMES.get(index); } 
    public static int getThemeCount() { return THEMES.size(); }
    public static int indexOfTheme(Theme t) { return THEMES.indexOf(t); }
    public static List<Theme> getThemes() {
    return Collections.unmodifiableList(THEMES);
}
    
     /**
     * Builds one meme from its folder. The four clue pictures are found
     * automatically inside /memes/{theme}/{memenum}/ and can each be a
     * png, jpg or gif.
     *
     * @param theme    the theme folder name, e.g. "postcovid"
     * @param memenum  the meme's folder name inside the theme, e.g. "meme01"
     * @param answer   the answer, e.g. "BOY DILA" (spaces and punctuation are allowed)
     * @param ansDialg the dialogue shown when the meme is solved
     * @return a new Meme ready to be added to a theme
     * @throws IllegalArgumentException if any of the four pictures is missing,
     *         or the answer isn't 3 to 11 letters
     */
    public static Meme makeMeme(String theme, String memenum, String answer, String ansDialg){
        String base = "/memes/" + theme + "/" + memenum + "/";
        return new Meme(answer, theme, new String[]{
                        getRevealPath(base, "1"),
                        getRevealPath(base, "2"),
                        getRevealPath(base, "3"),
                        getRevealPath(base, "4")}, ansDialg);
    }
    /**
     * Tells whether the player is allowed to open a theme. The first theme
     * is always open; every other theme opens once the one before it
     * has been completed.
     *
     * @param themeIndex the theme's position in {@link #THEMES} (0 is the first)
     * @return true if the theme is unlocked, false if it's still locked
     * @throws IndexOutOfBoundsException if there is no theme at that position
     */
    public static boolean isUnlocked(int themeIndex) {
        if (themeIndex == 0) return true;
        return THEMES.get(themeIndex -1).isNextUnlocked();
    }
    
    /**
     * Finds the picture file for one clue slide by trying png, then jpg,
     * then gif, and using the first one that exists.
     *
     * @param base the meme folder path ending in "/", e.g. "/memes/covid/meme03/"
     * @param num  the slide number as text, "1" to "4"
     * @return the resource path of the picture that was found
     * @throws IllegalArgumentException if none of the three file types exists
     */

    public static String getRevealPath(String base, String num) {
        String png = base + num + ".png";
        String jpg = base + num + ".jpg";
        String gif = base + num + ".gif";
        if (Meme.class.getResource(png) != null) {
            return png;
        }

        if (Meme.class.getResource(jpg) != null) {
            return jpg;
        }
        if (Meme.class.getResource(gif) != null){
            return gif;
        }
    throw new IllegalArgumentException(
        "Image not found! IDK WHAT U DID ALDRIAN U MESSED IT UP BRO"
    );
    }
}
