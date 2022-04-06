package com.example.musify.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "stageName", nullable = false)
    private String stageName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "startActivePeriod")
    private String startActivePeriod;

    @Column(name = "endActivePeriod")
    private String endActivePeriod;

    @ManyToMany
    private List<Song> songs;

    @ManyToMany
    private List<Album> albums;

    public Artist() {
    }

    public Artist(int id, String firstName, String lastName, String stageName, LocalDate birthday, String startActivePeriod, String endActivePeriod, List<Song> songs, List<Album> albums) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.birthday = birthday;
        this.startActivePeriod = startActivePeriod;
        this.endActivePeriod = endActivePeriod;
        this.songs = songs;
        this.albums = albums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
