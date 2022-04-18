package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.model.Playlist;
import com.example.musify.service.AlbumService;
import com.example.musify.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/musify/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PlaylistDTO>> getAll() {
        return new ResponseEntity<>(playlistService.getAllPlaylists(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        return ResponseEntity.ok().body(playlistService.savePlaylist(playlistDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlaylistDTO> updatePlaylist(@PathVariable("id") Integer id, @RequestBody PlaylistDTO playlistDTO) {
        return ResponseEntity.ok().body(playlistService.updatePlaylist(id, playlistDTO));
    }
}
