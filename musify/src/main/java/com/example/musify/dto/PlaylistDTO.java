package com.example.musify.dto;

import com.example.musify.model.SongPlaylist;
import com.example.musify.model.User;
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
public class PlaylistDTO {
    private String name;
    private String type;
    private LocalDate createdDate;
    private LocalDate lastUpdateDate;
    private Integer userId;
    private List<SongPlaylist> playlistSongs;
}
