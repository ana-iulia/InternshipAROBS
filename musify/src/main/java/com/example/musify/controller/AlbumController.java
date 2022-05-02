package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.model.Album;
import com.example.musify.service.AlbumService;
import com.example.musify.service.ArtistService;
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
@RequestMapping("/musify/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> getAll() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AlbumDTO> createAlbum(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid AlbumDTO albumDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(albumService.saveAlbum(albumDTO, words[1]));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable("id") Integer id, @RequestBody AlbumDTO albumDTO) {
        return ResponseEntity.ok().body(albumService.updateAlbum(id, albumDTO));
    }
    @PutMapping(params = {"idAlbum", "idSong"}, value = "/addSong")
    public ResponseEntity<AlbumDTO> addSongToAlbum(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idAlbum") Integer idAlbum, @RequestParam("idSong") Integer idSong) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(albumService.addSongToAlbum(idAlbum, idSong, words[1]));
    }

}
