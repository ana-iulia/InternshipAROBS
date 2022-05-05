package com.example.musify.service;

import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.mapper.PlaylistMapper;
import com.example.musify.mapper.SongMapper;
import com.example.musify.model.*;
import com.example.musify.repository.springdata.AlbumRepository;
import com.example.musify.repository.springdata.PlaylistRepository;
import com.example.musify.repository.springdata.SongRepository;
import com.example.musify.repository.springdata.UserRepository;
import com.example.musify.security.AuthorizationVerifier;
import com.example.musify.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class PlaylistService implements IPlaylistService {
    private static final String ERROR_MESSAGE = "You do not have permission for this request.";
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PlaylistMapper playlistMapper;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepository.findAll()
                .stream()
                .map(playlistMapper::toPlaylistDTO)
                .toList();
    }

    @Override
    public List<PlaylistDTO> getAllPublicPlaylists() {
        return playlistRepository.findAll()
                .stream()
                .filter(playlist -> playlist.getType().equals(Type.PUBLIC))
                .map(playlistMapper::toPlaylistDTO)
                .toList();
    }

    @Override
    public List<PlaylistDTO> getAllCreatedPlaylists() {
        Integer userId = JwtUtils.getUserIdFromSession();
        User user = userRepository.getById(userId);
        return user.getPlaylists()
                .stream()
                .map(playlistMapper::toPlaylistDTO)
                .toList();
    }

    @Override
    public List<PlaylistDTO> getAllFollowedPlaylists() {
        Integer userId = JwtUtils.getUserIdFromSession();
        User user = userRepository.getById(userId);
        return user.getFollowedPlaylists()
                .stream()
                .map(playlistMapper::toPlaylistDTO)
                .toList();
    }

    @Override
    @Transactional
    public PlaylistDTO savePlaylist(PlaylistCreateDTO playlistDTO) {
        Playlist playlist = playlistMapper.toPlaylistFromCreateEntity(playlistDTO);
        Integer userId = JwtUtils.getUserIdFromSession();
        User user = userRepository.getById(userId);
        playlist.setUser(userRepository.getById(userId));
        playlist.setCreatedDate(Date.valueOf(LocalDate.now()));
        playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
        user.getPlaylists().add(playlist);
        return playlistMapper.toPlaylistDTO(playlistRepository.save(playlist));
    }

    @Override
    @Transactional
    public PlaylistDTO updatePlaylist(Integer id, PlaylistDTO playlistDTO) throws UnauthorizedException {
        Playlist playlist = playlistRepository.getById(id);
        if (JwtUtils.getUserIdFromSession().equals(playlist.getUser().getId()) || AuthorizationVerifier.isAdmin()) {
            if (!playlistDTO.getName().equals("")) {
                playlist.setName(playlistDTO.getName());
            }
            playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
            return playlistMapper.toPlaylistDTO(playlist);
        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    @Transactional
    public PlaylistDTO addSongToPlaylist(Integer idPlaylist, Integer idSong) throws UnauthorizedException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (JwtUtils.getUserIdFromSession().equals(playlist.getUser().getId()) || AuthorizationVerifier.isAdmin()) {
            Song song = songRepository.getById(idSong);
            playlist.getSongs().add(song);
            playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
            return playlistMapper.toPlaylistDTO(playlist);
        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    @Transactional
    public PlaylistDTO addAlbumToPlaylist(Integer idPlaylist, Integer idAlbum) throws UnauthorizedException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (JwtUtils.getUserIdFromSession().equals(playlist.getUser().getId()) || AuthorizationVerifier.isAdmin()) {
            Album album = albumRepository.getById(idAlbum);
            album.getSongs().forEach(song -> playlist.getSongs().add(song));
            playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
            return playlistMapper.toPlaylistDTO(playlist);
        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    @Transactional
    public PlaylistDTO removeSongFromPlaylist(Integer idPlaylist, Integer idSong) throws UnauthorizedException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (JwtUtils.getUserIdFromSession().equals(playlist.getUser().getId()) || AuthorizationVerifier.isAdmin()) {
            Song song = songRepository.getById(idSong);
            if (playlist.getSongs().contains(song)) {
                playlist.getSongs().remove(song);
                playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
                return playlistMapper.toPlaylistDTO(playlist);
            }

        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    @Transactional
    public List<SongDTO> changeSongOrderInPlaylist(Integer idPlaylist, Integer idSong, Integer newPosition) throws UnauthorizedException {
        Playlist playlist = playlistRepository.getById(idPlaylist);
        if (JwtUtils.getUserIdFromSession().equals(playlist.getUser().getId()) || AuthorizationVerifier.isAdmin()) {
            Song song = songRepository.getById(idSong);
            if (playlist.getSongs().contains(song)) {
                playlist.getSongs().remove(song);
                playlist.getSongs().add(newPosition, song);
                playlist.setLastUpdateDate(Date.valueOf(LocalDate.now()));
                return playlist.getSongs()
                        .stream()
                        .map(songMapper::toSongDTO)
                        .toList();
            }

        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    @Transactional
    public String deletePlaylist(Integer id) {
        playlistRepository.deleteById(id);
        return "deleted";
    }

}
