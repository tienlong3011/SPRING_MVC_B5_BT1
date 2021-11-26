package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.model.SongForm;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    Song findOne(Long id);

    Song save(Song song);

    Song edit(Song song);

    List<Song> save(List<Song> songs);

    boolean exists(Long id);

    List<Song> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Song song);

    void delete(List<Song> songs);

    void deleteAll();
}
