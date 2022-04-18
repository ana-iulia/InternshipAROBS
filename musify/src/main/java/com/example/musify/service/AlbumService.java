package com.example.musify.service;


import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.ArtistDTO;
import com.example.musify.mapper.AlbumMapper;
import com.example.musify.mapper.ArtistMapper;
import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import com.example.musify.repository.springdata.AlbumRepository;
import com.example.musify.repository.springdata.ArtistRepository;
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
    private AlbumMapper albumMapper;

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return albumRepository.findAll().stream().map(albumMapper::toAlbumDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AlbumDTO saveAlbum(AlbumDTO albumDTO) {
        Album album = albumMapper.toAlbumEntity(albumDTO);
        return albumMapper.toAlbumDTO(albumRepository.save(album));
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

}
