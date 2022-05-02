package com.example.musify.dto;

import com.example.musify.model.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private Integer id;
    private String title;
    private String description;
    private String genre;
    private LocalDate releaseDate;
    private String label;
}
