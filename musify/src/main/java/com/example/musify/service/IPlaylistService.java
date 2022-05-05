package com.example.musify.service;

import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;

import java.util.List;

public interface IPlaylistService {
    List<PlaylistDTO> getAllPlaylists();

    PlaylistDTO savePlaylist( PlaylistCreateDTO playlistDTO);

    PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO) throws IllegalArgumentException;

    String deletePlaylist(Integer id);

    List<PlaylistDTO> getAllCreatedPlaylists();

    List<PlaylistDTO> getAllFollowedPlaylists();

    List<PlaylistDTO> getAllPublicPlaylists();

    PlaylistDTO addSongToPlaylist(Integer idPlaylist, Integer idSong) throws IllegalArgumentException;

    PlaylistDTO removeSongFromPlaylist(Integer idPlaylist, Integer idSong) throws IllegalArgumentException;

    List<SongDTO> changeSongOrderInPlaylist(Integer idPlaylist, Integer idSong, Integer newPosition) throws IllegalArgumentException;

    PlaylistDTO addAlbumToPlaylist(Integer idPlaylist, Integer idAlbum) throws IllegalArgumentException;
}
