package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.UnauthorizedException;
import org.webjars.NotFoundException;

import java.util.List;

public interface IArtistService {
    List<ArtistDTO> getAllArtists();

    ArtistDTO saveArtist(ArtistDTO artistDTO) throws UnauthorizedException;

    ArtistDTO updateArtist(Integer id, ArtistDTO artistDTO);



}
