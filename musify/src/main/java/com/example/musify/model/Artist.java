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
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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

    @OneToMany
    @JoinColumn(name = "artist_id")
    private List<Album> albums;

}
