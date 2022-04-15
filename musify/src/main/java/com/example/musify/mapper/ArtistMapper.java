package com.example.musify.mapper;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.model.Artist;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ArtistMapper {

    Artist toArtistEntity(ArtistDTO artistDTO);

    ArtistDTO toArtistDTO(Artist artist);
}
