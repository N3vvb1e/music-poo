package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the music database table.
 * 
 */
@Entity
@NamedQuery(name="Music.findAll", query="SELECT m FROM Music m")
public class Music implements Serializable, Comparable<Music> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String artist;

	private String genre;

	private String song;

	public Music() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtist() {
		return this.artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSong() {
		return this.song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
	@Override
    public String toString() {
        return this.song + " ~ " + this.artist + " ~ " + this.genre;
	}
	
	@Override
    public int compareTo(Music otherMusic) {
        return this.getSong().compareTo(otherMusic.getSong());
    }
}