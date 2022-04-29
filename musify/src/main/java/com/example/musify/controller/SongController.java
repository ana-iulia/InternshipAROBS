package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserRegisterDTO;
import com.example.musify.model.Role;
import com.example.musify.model.Song;
import com.example.musify.service.SongService;
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
@RequestMapping("/musify/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll() {
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SongDTO> createSong(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid SongDTO songDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(songService.saveSong(songDTO, words[1]));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<SongDTO> updateSong(@RequestHeader("authorization") HttpHeaders headers,@PathVariable("id") Integer id, @RequestBody SongDTO songDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(songService.updateSong(id, songDTO,words[1]));
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<List<SongDTO>> getAllSongsFromPlaylist(@PathVariable("id") Integer idPlaylist) {
        return new ResponseEntity<>(songService.getAllSongsFromPlaylist(idPlaylist), HttpStatus.OK);
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<SongDTO>> filterSortSongs(
            @RequestParam(required = false, defaultValue = "") String title
    ) {
        return new ResponseEntity<>(songService.filterSortSongs(title), HttpStatus.OK);
    }

}
