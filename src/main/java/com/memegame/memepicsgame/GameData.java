package com.memegame.memepicsgame;

import java.util.ArrayList;

public class GameData {
    public static final ArrayList<Theme> THEMES = new ArrayList<>();
    static {
       Theme postcovid = new Theme("postcovid", 0);
       Theme covid     = new Theme("covid", 0);
       Theme precovid  = new Theme("precovid", 0);
       //postCovid
       postcovid.addMeme(makeMeme("postcovid", "meme01", "bobet", "Mr.MVP himself"));
       postcovid.addMeme(makeMeme("postcovid", "meme02", "clowns", "This Gov is Circus"));
       postcovid.addMeme(makeMeme("postcovid", "meme03", "boydila", "Tradionalized Harrasment"));
       postcovid.addMeme(makeMeme("postcovid", "meme04", "aliceguo", "Send Alice Guo Baddie pics"));
       //Covid
       covid.addMeme(makeMeme("covid", "meme01", "sarado", "Bili sana ako eh..."));
       //Precovid
       precovid.addMeme(makeMeme("precovid", "meme01", "bulalord", "Yung sinusupsop!"));
       precovid.addMeme(makeMeme("precovid", "meme02", "jonathan", "Dunk it!"));
       precovid.addMeme(makeMeme("precovid", "meme03", "dota", "Comshop Classic"));
       precovid.addMeme(makeMeme("precovid", "meme04", "finish na", "WALA NA!"));
       precovid.addMeme(makeMeme("precovid", "meme05", "TABEMAINET", "HARANG HARANG KA PA DYAN!"));
       
      
       THEMES.add(postcovid);
       THEMES.add(covid);
       THEMES.add(precovid);
    }
    public static Meme makeMeme(String theme, String memenum, String answer, String ansDialg){
        String base = "/memes/" + theme + "/" + memenum + "/";
        return new Meme(answer, theme, new String[]{
            base + "1.png", base + "2.png", base + "3.png", base + "4.png"}, ansDialg);
    }
    
    public static boolean isUnlocked(int themeIndex) {
        if (themeIndex == 0) return true;
        return THEMES.get(themeIndex -1).isNextUnlocked();
    }
}
