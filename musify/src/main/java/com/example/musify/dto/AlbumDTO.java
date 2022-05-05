package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

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
