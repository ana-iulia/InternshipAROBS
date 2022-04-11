package com.example.musify.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "startActivePeriod")
    private String startActivePeriod;

    @Column(name = "endActivePeriod")
    private String endActivePeriod;

    @ManyToMany
    private List<Artist> artists;

    @ManyToMany
    private List<Song> songs;

    @ManyToMany
    private List<Album> albums;

    public Band() {
    }

    public Band(int id, String name, String location, String startActivePeriod, String endActivePeriod, List<Artist> artists, List<Song> songs, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.startActivePeriod = startActivePeriod;
        this.endActivePeriod = endActivePeriod;
        this.artists = artists;
        this.songs = songs;
        this.albums = albums;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartActivePeriod() {
        return startActivePeriod;
    }

    public void setStartActivePeriod(String startActivePeriod) {
        this.startActivePeriod = startActivePeriod;
    }

    public String getEndActivePeriod() {
        return endActivePeriod;
    }

    public void setEndActivePeriod(String endActivePeriod) {
        this.endActivePeriod = endActivePeriod;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
