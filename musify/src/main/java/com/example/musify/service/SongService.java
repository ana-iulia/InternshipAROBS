package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.mapper.SongMapper;
import com.example.musify.model.Artist;
import com.example.musify.model.Song;
import com.example.musify.repository.springdata.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongService implements ISongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongMapper songMapper;

    @Override
    public List<SongDTO> getAllSongs() {
        return songRepository.findAll().stream().map(songMapper::toSongDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SongDTO saveSong(SongDTO songDTO) {
        Song song = songMapper.toSongEntity(songDTO);
        return songMapper.toSongDTO(songRepository.save(song));
    }

    @Override
    @Transactional
    public SongDTO updateSong(Integer id, SongDTO songDTO) {
        Song song = songRepository.getById(id);
        if (!songDTO.getTitle().equals("")) {
            song.setTitle(songDTO.getTitle());
        }
        if (songDTO.getDuration() != null && !songDTO.getDuration().equals("")) {
            song.setDuration(songDTO.getDuration());
        }
        if (songDTO.getCreationDate() != null && !songDTO.getCreationDate().equals("")) {
            song.setCreationDate(songDTO.getCreationDate());
        }

        return songMapper.toSongDTO(song);
    }
}
