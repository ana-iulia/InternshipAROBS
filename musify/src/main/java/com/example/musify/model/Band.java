package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "bands")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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

//    @ManyToMany
//    private List<Song> songs;

    @OneToMany
    @JoinColumn(name = "band_id")
    private List<Album> albums;


}
