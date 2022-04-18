package com.example.musify.mapper;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.ArtistDTO;
import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AlbumMapper {
    Album toAlbumEntity(AlbumDTO albumDTO);

    AlbumDTO toAlbumDTO(Album album);
}
