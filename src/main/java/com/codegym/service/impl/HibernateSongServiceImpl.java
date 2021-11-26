package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateSongServiceImpl implements SongService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAll() {
        String queryStr = "SELECT s FROM Song AS s";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public Song findOne(Long id) {
        String queryStr = "SELECT s FROM Song AS s WHERE s.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Song save(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(song);
            transaction.commit();
            return song;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Song edit(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Song origin = findOne(song.getId());
            origin.setNameSong(song.getNameSong());
            origin.setSinger(song.getSinger());
            origin.setMusicGenre(song.getMusicGenre());
            origin.setSongFilePath(song.getSongFilePath());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Song> save(List<Song> songs) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Song> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(song);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(List<Song> songs) {

    }

    @Override
    public void deleteAll() {

    }
}
