package com.example.musify.mapper;


import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.model.Artist;
import com.example.musify.model.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song toSongEntity(SongDTO songDTO);

    SongDTO toSongDTO(Song song);
}
