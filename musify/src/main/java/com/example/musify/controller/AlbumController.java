package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.ArtistDTO;
import com.example.musify.model.Album;
import com.example.musify.service.AlbumService;
import com.example.musify.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AlbumDTO>> getAll() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        return ResponseEntity.ok().body(albumService.saveAlbum(albumDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable("id") Integer id, @RequestBody AlbumDTO albumDTO) {
        return ResponseEntity.ok().body(albumService.updateAlbum(id, albumDTO));
    }
}
