package service;

@SuppressWarnings("serial")
public class MusicNotFoundException extends Exception {
    public MusicNotFoundException(String message) {
        super(message);
    }
}
