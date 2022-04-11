package com.example.musify.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "songs_playlists")
public class SongPlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne
    private Song song;

    @ManyToOne
    private Playlist playlist;

    @Column(name = "songOrderNumber")
    private int songOrderNumber;

    public SongPlaylist() {
    }

    public SongPlaylist(int id, Song song, Playlist playlist, int songOrderNumber) {
        this.id = id;
        this.song = song;
        this.playlist = playlist;
        this.songOrderNumber = songOrderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getSongOrderNumber() {
        return songOrderNumber;
    }

    public void setSongOrderNumber(int songOrderNumber) {
        this.songOrderNumber = songOrderNumber;
    }
}
