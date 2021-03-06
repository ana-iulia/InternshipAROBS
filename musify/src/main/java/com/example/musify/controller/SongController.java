package com.example.musify.controller;

import com.example.musify.dto.SongDTO;
import com.example.musify.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/musify")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public ResponseEntity<List<SongDTO>> getAll() {
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @PostMapping("/song")
    public ResponseEntity<SongDTO> createSong(@RequestBody @Valid SongDTO songDTO) {
        return ResponseEntity.ok().body(songService.saveSong(songDTO));
    }


    @PutMapping("/song/{id}")
    public ResponseEntity<SongDTO> updateSong(@PathVariable("id") Integer id, @RequestBody SongDTO songDTO) {
        return ResponseEntity.ok().body(songService.updateSong(id, songDTO));
    }

    @GetMapping("/song/playlist/{id}")
    public ResponseEntity<List<SongDTO>> getAllSongsFromPlaylist(@PathVariable("id") Integer idPlaylist) {
        return new ResponseEntity<>(songService.getAllSongsFromPlaylist(idPlaylist), HttpStatus.OK);
    }

    @GetMapping("/song-filtered")
    public ResponseEntity<List<SongDTO>> filterSortSongs(
            @RequestParam(required = false, defaultValue = "") String title
    ) {
        return new ResponseEntity<>(songService.filterSortSongs(title), HttpStatus.OK);
    }


}
