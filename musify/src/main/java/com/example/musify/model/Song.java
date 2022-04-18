package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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


}
