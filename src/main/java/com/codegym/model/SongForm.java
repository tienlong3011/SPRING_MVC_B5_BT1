package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private long id;
    private String nameSong;
    private String singer;
    private String musicGenre;
    private MultipartFile songFilePath;

    public SongForm() {
    }

    public SongForm(String nameSong, String singer, String musicGenre, MultipartFile songFilePath) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.musicGenre = musicGenre;
        this.songFilePath = songFilePath;
    }

    public SongForm(long id, String nameSong, String singer, String musicGenre, MultipartFile songFilePath) {
        this.id = id;
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

    public MultipartFile getSongFilePath() {
        return songFilePath;
    }

    public void setSongFilePath(MultipartFile songFilePath) {
        this.songFilePath = songFilePath;
    }
}
