package com.example.musify.mapper;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.model.Album;
import com.example.musify.model.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    Playlist toPlaylistEntity(PlaylistDTO playlistDTO);

    //@Mapping(target = "userId", source = "user")
    PlaylistDTO toPlaylistDTO(Playlist playlist);

    Playlist toPlaylistFromCreateEntity(PlaylistCreateDTO playlistDTO);

    PlaylistCreateDTO toPlaylistCreateDTO(Playlist playlist);
}
