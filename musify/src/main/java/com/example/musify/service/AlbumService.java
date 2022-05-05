package com.example.musify.service;


import com.example.musify.dto.AlbumDTO;
import com.example.musify.exception.UnauthorizedException;
import com.example.musify.mapper.AlbumMapper;
import com.example.musify.model.*;
import com.example.musify.repository.springdata.AlbumRepository;
import com.example.musify.repository.springdata.SongRepository;
import com.example.musify.security.AuthorizationVerifier;
import com.example.musify.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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


    @Override
    public List<AlbumDTO> getAllAlbums() {
        return albumRepository.findAll()
                .stream()
                .map(albumMapper::toAlbumDTO)
                .toList();
    }

    @Override
    @Transactional
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) throws UnauthorizedException {
        if (AuthorizationVerifier.isAdmin()) {
            Album album = albumMapper.toAlbumEntity(albumDTO);
            return albumMapper.toAlbumDTO(albumRepository.save(album));
        }
        throw new UnauthorizedException("You do not have permission for this request.");
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

        if (albumDTO.getReleaseDate() != null) {
            album.setReleaseDate(albumDTO.getReleaseDate());
        }

        return albumMapper.toAlbumDTO(album);
    }


    @Override
    @Transactional
    public AlbumDTO addSongToAlbum(Integer idAlbum, Integer idSong) throws UnauthorizedException {
        Album album = albumRepository.getById(idAlbum);
        if (AuthorizationVerifier.isAdmin()) {
            Song song = songRepository.getById(idSong);
            album.getSongs().add(song);
            return albumMapper.toAlbumDTO(album);
        }
        throw new UnauthorizedException("You do not have permission for this request.");
    }

}
