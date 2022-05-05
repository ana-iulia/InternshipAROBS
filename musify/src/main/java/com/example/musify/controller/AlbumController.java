package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.service.AlbumService;
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
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumDTO>> getAll() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @PostMapping("/album")
    public ResponseEntity<AlbumDTO> createAlbum(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid AlbumDTO albumDTO) {
        return ResponseEntity.ok().body(albumService.saveAlbum(albumDTO));
    }

    @PutMapping("/album/{id}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable("id") Integer id, @RequestBody AlbumDTO albumDTO) {
        return ResponseEntity.ok().body(albumService.updateAlbum(id, albumDTO));
    }
    @PutMapping(params = {"idAlbum", "idSong"}, value = "/album/song")
    public ResponseEntity<AlbumDTO> addSongToAlbum(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idAlbum") Integer idAlbum, @RequestParam("idSong") Integer idSong) {
        return ResponseEntity.ok().body(albumService.addSongToAlbum(idAlbum, idSong));
    }

}
