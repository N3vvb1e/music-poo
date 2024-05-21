package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Music;

public class MusicDao extends GenericDao<Music> {
    private EntityManagerFactory factory;

    public MusicDao(EntityManagerFactory factory) {
        super(Music.class);
        this.factory = factory;
    }


    @Override
    public EntityManager getEntityManager() {
        try {
            return factory.createEntityManager();
        } catch (Exception ex) {
            System.out.println("The entity manager cannot be created!");
            return null;
        }
    }
}