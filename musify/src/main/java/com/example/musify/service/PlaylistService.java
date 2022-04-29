package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.mapper.AlbumMapper;
import com.example.musify.mapper.PlaylistMapper;
import com.example.musify.mapper.SongMapper;
import com.example.musify.model.*;
import com.example.musify.repository.springdata.AlbumRepository;
import com.example.musify.repository.springdata.PlaylistRepository;
import com.example.musify.repository.springdata.SongRepository;
import com.example.musify.repository.springdata.UserRepository;
import com.example.musify.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistMapper playlistMapper;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepository.findAll().stream().map(playlistMapper::toPlaylistDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlaylistDTO> getAllPublicPlaylists() {
        return playlistRepository.findAll().stream().filter(playlist -> playlist.getType().equals(Type.PUBLIC)).map(playlistMapper::toPlaylistDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlaylistDTO> getAllCreatedPlaylists(String token) {
        Integer userId = jwtUtils.getIdFromToken(token);
        User user = userRepository.getById(userId);
        return user.getPlaylists().stream().map(playlistMapper::toPlaylistDTO).collect(Collectors.toList());
    }

    @Override
    public List<PlaylistDTO> getAllFollowedPlaylists(String token) {
        Integer userId = jwtUtils.getIdFromToken(token);
        User user = userRepository.getById(userId);
        return user.getFollowedPlaylists().stream().map(playlistMapper::toPlaylistDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PlaylistDTO savePlaylist(String token, PlaylistCreateDTO playlistDTO) {
        Playlist playlist = playlistMapper.toPlaylistFromCreateEntity(playlistDTO);
        Integer userId = jwtUtils.getIdFromToken(token);
        User user = userRepository.getById(userId);
        playlist.setUser(userRepository.getById(userId));
        playlist.setCreatedDate(Date.valueOf(LocalDate.now()));
        playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
        user.getPlaylists().add(playlist);
        return playlistMapper.toPlaylistDTO(playlistRepository.save(playlist));
    }

    @Override
    @Transactional
    public PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO, String token) throws IllegalArgumentException {
        Playlist playlist = playlistRepository.getById(id);
        if (jwtUtils.getIdFromToken(token).equals(playlist.getUser().getId())) {
            if (!playlistDTO.getName().equals("")) {
                playlist.setName(playlistDTO.getName());
            }
            if (!playlistDTO.getType().equals("")) {
                playlist.setType(playlistDTO.getType());
            }
            playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
            return playlistMapper.toPlaylistDTO(playlist);
        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

    @Override
    @Transactional
    public PlaylistDTO addSongToPlaylist(Integer idPlaylist, Integer idSong, String token) throws IllegalArgumentException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (jwtUtils.getIdFromToken(token).equals(playlist.getUser().getId())) {
            Song song = songRepository.getById(idSong);
            playlist.getSongs().add(song);
            playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
            return playlistMapper.toPlaylistDTO(playlist);
        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

    @Override
    @Transactional
    public PlaylistDTO removeSongFromPlaylist(Integer idPlaylist, Integer idSong, String token) throws IllegalArgumentException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (jwtUtils.getIdFromToken(token).equals(playlist.getUser().getId())) {
            Song song = songRepository.getById(idSong);
            if (playlist.getSongs().contains(song)) {
                playlist.getSongs().remove(song);
                playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
                return playlistMapper.toPlaylistDTO(playlist);
            }

        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

    @Override
    @Transactional
    public List<SongDTO> changeSongOrderInPlaylist(Integer idPlaylist, Integer idSong, Integer newPosition, String token) throws IllegalArgumentException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (jwtUtils.getIdFromToken(token).equals(playlist.getUser().getId())) {
            Song song = songRepository.getById(idSong);
            if (playlist.getSongs().contains(song)) {
                playlist.getSongs().remove(song);
                playlist.getSongs().add(newPosition, song);
                playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
                return playlist.getSongs().stream().map(songMapper::toSongDTO).collect(Collectors.toList());
            }

        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

    @Override
    @Transactional
    public String deletePlaylist(Integer id) {
        playlistRepository.deleteById(id);
        return "deleted";
    }

}
