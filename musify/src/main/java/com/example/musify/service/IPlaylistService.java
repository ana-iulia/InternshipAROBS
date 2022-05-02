package com.example.musify.service;

import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> getAllPlaylists();

    PlaylistDTO savePlaylist(String token, PlaylistCreateDTO playlistDTO);

    PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO, String token) throws IllegalArgumentException;

    String deletePlaylist(Integer id);

    List<PlaylistDTO> getAllCreatedPlaylists(String token);

    List<PlaylistDTO> getAllFollowedPlaylists(String token);

    List<PlaylistDTO> getAllPublicPlaylists();

    PlaylistDTO addSongToPlaylist(Integer idPlaylist, Integer idSong, String token) throws IllegalArgumentException;

    PlaylistDTO removeSongFromPlaylist(Integer idPlaylist, Integer idSong, String token) throws IllegalArgumentException;

    List<SongDTO> changeSongOrderInPlaylist(Integer idPlaylist, Integer idSong, Integer newPosition, String token) throws IllegalArgumentException;

    PlaylistDTO addAlbumToPlaylist(Integer idPlaylist, Integer idAlbum, String token) throws IllegalArgumentException;
}
