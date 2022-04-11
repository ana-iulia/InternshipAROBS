package com.example.musify.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "createdDate")
    private LocalDate createdDate;


    @Column(name = "lastUpdateDate")
    private LocalDate lastUpdateDate;

    @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "playlist_id")
    private List<SongPlaylist> playlistSongs;

    public Playlist() {
    }

    public Playlist(int id, String name, String type, LocalDate createdDate, LocalDate lastUpdateDate, User user, List<SongPlaylist> playlistSongs) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createdDate = createdDate;
        this.lastUpdateDate = lastUpdateDate;
        this.user = user;
        this.playlistSongs = playlistSongs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SongPlaylist> getPlaylistSongs() {
        return playlistSongs;
    }

    public void setPlaylistSongs(List<SongPlaylist> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }
}
