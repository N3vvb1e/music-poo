package model;

public enum MusicGenre {
	POP("Pop"),
	HIPHOP("Hip Hop"),
	ROCK("Rock"),
    BLUES("Blues"),
    SOUL("Soul"),
    REGGAE("Reggae"),
    COUNTRY("Country");
    
    private String value;

    private MusicGenre(String value) {
       this.value = value;
    }
    
    public String getValue() {
    	return value;
    }
}