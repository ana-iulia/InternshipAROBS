package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import org.webjars.NotFoundException;

import java.util.List;

public interface IArtistService {
    List<ArtistDTO> getAllArtists();

    ArtistDTO saveArtist(ArtistDTO artistDTO, String token) throws IllegalArgumentException;

    ArtistDTO updateArtist(Integer id, ArtistDTO artistDTO);

}
