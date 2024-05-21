package service;

import java.util.List;

import javax.persistence.Persistence;

import dao.MusicDao;
import model.Music;

public class MusicService {
    private MusicDao musicDao;

    public MusicService() {
        try {
            musicDao = new MusicDao(Persistence.createEntityManagerFactory("Music"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addMusic(Music newMusic) {
        musicDao.create(newMusic);
    }

    public void updateMusic(Music updatedMusic) {
        musicDao.update(updatedMusic);
    }

    public void removeMusic(Music music) {
        musicDao.remove(music, music.getId());
    }

    public List<Music> getAllMusic() {
        return musicDao.findAll();
    }
}