package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;

import java.util.List;

public interface IAlbumService {
    List<AlbumDTO> getAllAlbums();

    AlbumDTO saveAlbum(AlbumDTO albumDTO);

    AlbumDTO updateAlbum(Integer id, AlbumDTO albumDTO);
}
