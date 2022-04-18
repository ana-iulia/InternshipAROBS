package com.example.musify.service;

import com.example.musify.dto.SongDTO;

import java.util.List;

public interface ISongService {
    List<SongDTO> getAllSongs();

    SongDTO saveSong(SongDTO songDTO);

    SongDTO updateSong(Integer id, SongDTO songDTO);
}
