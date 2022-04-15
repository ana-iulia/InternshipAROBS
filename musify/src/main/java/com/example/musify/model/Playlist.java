package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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

}
