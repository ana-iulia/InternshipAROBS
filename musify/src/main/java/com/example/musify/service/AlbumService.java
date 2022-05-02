package com.example.musify.service;


import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.mapper.AlbumMapper;
import com.example.musify.mapper.ArtistMapper;
import com.example.musify.model.*;
import com.example.musify.repository.springdata.AlbumRepository;
import com.example.musify.repository.springdata.ArtistRepository;
import com.example.musify.repository.springdata.SongRepository;
import com.example.musify.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService implements IAlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return albumRepository.findAll().stream().map(albumMapper::toAlbumDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AlbumDTO saveAlbum(AlbumDTO albumDTO, String token) throws IllegalArgumentException {
        if (jwtUtils.getRoleFromToken(token).equals(Role.ADMIN)) {
            Album album = albumMapper.toAlbumEntity(albumDTO);
            return albumMapper.toAlbumDTO(albumRepository.save(album));
        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

    @Override
    @Transactional
    public AlbumDTO updateAlbum(Integer id, AlbumDTO albumDTO) {
        Album album = albumRepository.getById(id);
        if (!albumDTO.getDescription().equals("")) {
            album.setDescription(albumDTO.getDescription());
        }
        if (!albumDTO.getGenre().equals("")) {
            album.setGenre(albumDTO.getGenre());
        }
        if (!albumDTO.getTitle().equals("")) {
            album.setTitle(albumDTO.getTitle());
        }
        if (!albumDTO.getLabel().equals("")) {
            album.setLabel(albumDTO.getLabel());
        }

        if (albumDTO.getReleaseDate() != null && !albumDTO.getReleaseDate().equals("")) {
            album.setReleaseDate(albumDTO.getReleaseDate());
        }

        return albumMapper.toAlbumDTO(album);
    }


    @Override
    @Transactional
    public AlbumDTO addSongToAlbum(Integer idAlbum, Integer idSong, String token) throws IllegalArgumentException {
        Album album = albumRepository.getById(idAlbum);
        if (jwtUtils.getRoleFromToken(token).equals(Role.ADMIN)) {
            Song song = songRepository.getById(idSong);
            album.getSongs().add(song);
            return albumMapper.toAlbumDTO(album);
        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

}
