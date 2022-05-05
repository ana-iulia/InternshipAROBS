package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;
import com.example.musify.service.ArtistService;
import com.example.musify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/musify")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistDTO>> getAll() {
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }

    @PostMapping("/artist")
    public ResponseEntity<ArtistDTO> createArtist(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid ArtistDTO artistDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(artistService.saveArtist(artistDTO, words[1]));
    }

    @PutMapping("/artist/{id}")
    public ResponseEntity<ArtistDTO> updateArtist(@PathVariable("id") Integer id, @RequestBody ArtistDTO artistDTO) {
        return ResponseEntity.ok().body(artistService.updateArtist(id, artistDTO));
    }
}
