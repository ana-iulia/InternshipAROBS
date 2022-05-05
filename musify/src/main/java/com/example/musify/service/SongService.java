package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.mapper.SongMapper;
import com.example.musify.model.Artist;
import com.example.musify.model.Playlist;
import com.example.musify.model.Role;
import com.example.musify.model.Song;
import com.example.musify.repository.springdata.PlaylistRepository;
import com.example.musify.repository.springdata.SongRepository;
import com.example.musify.security.AuthorizationVerifier;
import com.example.musify.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongService implements ISongService {
    private static final String ERROR_MESSAGE = "You do not have permission for this request.";

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public List<SongDTO> getAllSongs() {
        return songRepository.findAll()
                .stream()
                .map(songMapper::toSongDTO)
                .toList();
    }

    @Override
    public List<SongDTO> getAllSongsFromPlaylist(Integer idPlaylist) {
        return playlistRepository.getById(idPlaylist).getSongs()
                .stream()
                .map(songMapper::toSongDTO)
                .toList();
    }

    @Override
    @Transactional
    public SongDTO saveSong(SongDTO songDTO) throws UnauthorizedException {
        if (AuthorizationVerifier.isAdmin()) {
            Song song = songMapper.toSongEntity(songDTO);
            return songMapper.toSongDTO(songRepository.save(song));
        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    @Transactional
    public SongDTO updateSong(Integer id, SongDTO songDTO) throws UnauthorizedException {
        if (AuthorizationVerifier.isAdmin()) {
            Song song = songRepository.getById(id);
            if (!songDTO.getTitle().equals("")) {
                song.setTitle(songDTO.getTitle());
            }
            if (songDTO.getDuration() != null) {
                song.setDuration(songDTO.getDuration());
            }
            if (songDTO.getCreationDate() != null) {
                song.setCreationDate(songDTO.getCreationDate());
            }

            return songMapper.toSongDTO(song);
        }
        throw new UnauthorizedException(ERROR_MESSAGE);
    }

    @Override
    public List<SongDTO> filterSortSongs(String title) {
        List<Song> filteredSortedSongs = songRepository.filterSortSongs(title);

        return filteredSortedSongs
                .stream()
                .map(songMapper::toSongDTO)
                .toList();
    }

}
