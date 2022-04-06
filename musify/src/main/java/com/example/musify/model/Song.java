package com.example.musify.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration")
    private LocalTime duration;


    @Column(name = "creationDate")
    private LocalDate creationDate;

    @OneToMany
    @JoinColumn(name = "song_id")
    private List<SongPlaylist> songPlaylists;

    @OneToMany
    @JoinColumn(name = "song_id")
    private List<SongAlternativeTitle> songAlternativeTitles;

    public Song() {
    }

    public Song(int id, String title, LocalTime duration, LocalDate creationDate, List<SongPlaylist> songPlaylists, List<SongAlternativeTitle> songAlternativeTitles) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.creationDate = creationDate;
        this.songPlaylists = songPlaylists;
        this.songAlternativeTitles = songAlternativeTitles;
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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<SongPlaylist> getSongPlaylists() {
        return songPlaylists;
    }

    public void setSongPlaylists(List<SongPlaylist> songPlaylists) {
        this.songPlaylists = songPlaylists;
    }

    public List<SongAlternativeTitle> getSongAlternativeTitles() {
        return songAlternativeTitles;
    }

    public void setSongAlternativeTitles(List<SongAlternativeTitle> songAlternativeTitles) {
        this.songAlternativeTitles = songAlternativeTitles;
    }
}
