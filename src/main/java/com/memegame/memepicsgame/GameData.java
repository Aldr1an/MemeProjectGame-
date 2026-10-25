package com.memegame.memepicsgame;

import java.util.ArrayList;

public class GameData {
    public static final ArrayList<Theme> THEMES = new ArrayList<>();
    public static int currentTheme = 0;
    static {
       Theme postcovid = new Theme("postcovid", 0);
       Theme covid     = new Theme("covid", 0);
       Theme precovid  = new Theme("precovid", 0);
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
       postcovid.addMeme(makeMeme("postcovid", "meme15", "SOPHIEPRIME", "YOOHOO, DITO ANG TINGIN"));
       
       //Covid
       covid.addMeme(makeMeme("covid", "meme01", "AH SARADO?", "Bili sana ako eh..."));
       //Precovid
       precovid.addMeme(makeMeme("precovid", "meme01", "BULALORD", "Yung sinusupsop!"));
       precovid.addMeme(makeMeme("precovid", "meme02", "JONATHAN", "Dunk it!"));
       precovid.addMeme(makeMeme("precovid", "meme03", "DOTA", "Anong pipiliin mo?!"));
       precovid.addMeme(makeMeme("precovid", "meme04", "FINISH NA", "WALA NA!"));
       precovid.addMeme(makeMeme("precovid", "meme05", "TABE MAINET", "HARANG HARANG KA PA DYAN!"));
       
      
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
