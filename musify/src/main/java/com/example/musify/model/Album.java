package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "label")
    private String label;

    @ManyToMany
    @OrderColumn
    @JoinColumn(name = "album_id")
    private List<Song> songs= new LinkedList<>();
}
