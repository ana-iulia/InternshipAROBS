package com.example.musify.service;

import com.example.musify.dto.SongDTO;
import com.example.musify.exception.UnauthorizedException;

import java.util.List;

public interface ISongService {
    List<SongDTO> getAllSongs();

    SongDTO saveSong(SongDTO songDTO) throws UnauthorizedException;

    SongDTO updateSong(Integer id, SongDTO songDTO) throws UnauthorizedException;

    List<SongDTO> getAllSongsFromPlaylist(Integer idPlaylist);

    List<SongDTO> filterSortSongs(String title);
}
