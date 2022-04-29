package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "createdDate")
    private Date createdDate;


    @Column(name = "lastUpdateDate")
    private Date lastUpdateDate;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinColumn(name = "playlist_id")
    private List<Song> songs= new LinkedList<>();
    //private LinkedList<SongPlaylist> playlistSongs;
    //LinkedList<SongPlaylist> playlistSongs = new LinkedList<>();

}
