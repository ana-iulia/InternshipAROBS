package com.example.musify.model;

import javax.persistence.*;

@Entity
@Table(name = "song_alternative_titles")
public class SongAlternativeTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "language", nullable = false)
    private String language;

    @ManyToOne
    private Song song;

    public SongAlternativeTitle() {
    }

    public SongAlternativeTitle(int id, String title, String language, Song song) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.song = song;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
