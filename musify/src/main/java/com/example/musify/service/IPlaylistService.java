package com.example.musify.service;

import com.example.musify.dto.PlaylistDTO;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> getAllPlaylists();

    PlaylistDTO savePlaylist(PlaylistDTO playlistDTO);

    PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO);
}
