package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;
import com.example.musify.service.ArtistService;
import com.example.musify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/musify/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ArtistDTO>> getAll() {
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ArtistDTO> createArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        return ResponseEntity.ok().body(artistService.saveArtist(artistDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ArtistDTO> updateArtist(@PathVariable("id") Integer id, @RequestBody ArtistDTO artistDTO) {
        return ResponseEntity.ok().body(artistService.updateArtist(id, artistDTO));
    }
}
