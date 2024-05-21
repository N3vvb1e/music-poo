package controller;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MusicValidator {
    private static final String SONG_PATTERN = "^[A-Za-z0-9\\s]+$"; // Pattern pentru validarea numelui cantecului

    public static boolean isValidSong(String song) {
        Pattern pattern = Pattern.compile(SONG_PATTERN);
        Matcher matcher = pattern.matcher(song);
        return matcher.matches();
    }
}
