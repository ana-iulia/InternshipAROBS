package com.example.musify.service;

import com.example.musify.dto.SongDTO;

import java.util.List;

public interface ISongService {
    List<SongDTO> getAllSongs();

    SongDTO saveSong(SongDTO songDTO, String token) throws IllegalArgumentException;

    SongDTO updateSong(Integer id, SongDTO songDTO, String token) throws IllegalArgumentException;

    List<SongDTO> getAllSongsFromPlaylist(Integer idPlaylist);

    List<SongDTO> filterSortSongs(String title);
}
