package com.example.musify.service;

import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> getAllPlaylists();

    PlaylistDTO savePlaylist(PlaylistCreateDTO playlistDTO);

    PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO);

    String deletePlaylist(Integer id);
}
