package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.mapper.AlbumMapper;
import com.example.musify.mapper.PlaylistMapper;
import com.example.musify.model.Album;
import com.example.musify.model.Playlist;
import com.example.musify.repository.springdata.AlbumRepository;
import com.example.musify.repository.springdata.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistMapper playlistMapper;

    @Override
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepository.findAll().stream().map(playlistMapper::toPlaylistDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PlaylistDTO savePlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = playlistMapper.toPlaylistEntity(playlistDTO);
        return playlistMapper.toPlaylistDTO(playlistRepository.save(playlist));
    }

    @Override
    @Transactional
    public PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO) {
        Playlist playlist = playlistRepository.getById(id);
        if (!playlistDTO.getName().equals("")) {
            playlist.setName(playlistDTO.getName());
        }
        if (!playlistDTO.getType().equals("")) {
            playlist.setType(playlistDTO.getType());
        }


        if (playlistDTO.getCreatedDate() != null && !playlistDTO.getCreatedDate().equals("")) {
            playlist.setCreatedDate(playlistDTO.getCreatedDate());
        }

        return playlistMapper.toPlaylistDTO(playlist);
    }
}
