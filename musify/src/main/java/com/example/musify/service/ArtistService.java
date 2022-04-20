package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.mapper.ArtistMapper;
import com.example.musify.model.Artist;
import com.example.musify.model.Role;
import com.example.musify.repository.springdata.ArtistRepository;
import com.example.musify.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService implements IArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public List<ArtistDTO> getAllArtists() {
        return artistRepository.findAll().stream().map(artistMapper::toArtistDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ArtistDTO saveArtist(ArtistDTO artistDTO,String token) throws IllegalArgumentException{
        if (jwtUtils.getRoleFromToken(token).equals(Role.ADMIN)) {
            Artist artist = artistMapper.toArtistEntity(artistDTO);
            return artistMapper.toArtistDTO(artistRepository.save(artist));
        }
        throw new IllegalArgumentException("You do not have permission for this request.");
    }

    @Override
    @Transactional
    public ArtistDTO updateArtist(Integer id, ArtistDTO artistDTO) {
        Artist artist = artistRepository.getById(id);
        if (!artistDTO.getFirstName().equals("")) {
            artist.setFirstName(artistDTO.getFirstName());
        }
        if (!artistDTO.getLastName().equals("")) {
            artist.setLastName(artistDTO.getLastName());
        }
        if (!artistDTO.getStageName().equals("")) {
            artist.setStageName(artistDTO.getStageName());
        }
        if (artistDTO.getBirthday() != null && !artistDTO.getBirthday().equals("")) {
            artist.setBirthday(artistDTO.getBirthday());
        }
        if (!artistDTO.getStartActivePeriod().equals("")) {
            artist.setStartActivePeriod(artistDTO.getStartActivePeriod());
        }
        if (!artistDTO.getEndActivePeriod().equals("")) {
            artist.setEndActivePeriod(artistDTO.getEndActivePeriod());
        }

        return artistMapper.toArtistDTO(artist);
    }


}
