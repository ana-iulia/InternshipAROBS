package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.exception.UnauthorizedException;

import java.util.List;

public interface IAlbumService {
    List<AlbumDTO> getAllAlbums();

    AlbumDTO saveAlbum(AlbumDTO albumDTO) throws UnauthorizedException;

    AlbumDTO updateAlbum(Integer id, AlbumDTO albumDTO);

    AlbumDTO addSongToAlbum(Integer idAlbum, Integer idSong) throws UnauthorizedException;
}
