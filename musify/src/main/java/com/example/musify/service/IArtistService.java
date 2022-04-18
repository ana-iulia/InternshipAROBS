package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;

import java.util.List;

public interface IArtistService {
    List<ArtistDTO> getAllArtists();

    ArtistDTO saveArtist(ArtistDTO artistDTO);

    ArtistDTO updateArtist(Integer id, ArtistDTO artistDTO);

}
