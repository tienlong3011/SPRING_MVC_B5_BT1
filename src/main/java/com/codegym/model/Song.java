package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameSong;
    private String singer;
    private String musicGenre;
    private String songFilePath;

    public Song() {
    }

    public Song(long id, String nameSong, String singer, String musicGenre, String songFilePath) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.songFilePath = songFilePath;
    }

    public Song(String nameSong, String singer, String musicGenre, String songFilePath) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.songFilePath = songFilePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(String songFilePath) {
        this.songFilePath = songFilePath;
    }

    public Song clone(){
        Song song = new Song();
        song.setId(id);
        song.setNameSong(nameSong);
        song.setSinger(singer);
        song.setMusicGenre(musicGenre);
        song.setSongFilePath(songFilePath);
        return song;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", nameSong='" + nameSong + '\'' +
                ", singer='" + singer + '\'' +
                ", musicGenre='" + musicGenre + '\'' +
                ", songFilePath='" + songFilePath + '\'' +
                '}';
    }
}
