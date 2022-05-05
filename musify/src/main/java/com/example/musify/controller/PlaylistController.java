package com.example.musify.controller;

import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;
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
@RequestMapping("/musify")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public ResponseEntity<List<PlaylistDTO>> getAll() {
        return new ResponseEntity<>(playlistService.getAllPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/public-playlists")
    public ResponseEntity<List<PlaylistDTO>> getAllPublicPlaylists() {
        return new ResponseEntity<>(playlistService.getAllPublicPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/user-created-playlists")
    public ResponseEntity<List<PlaylistDTO>> getAllCreatedPlaylists() {
        return new ResponseEntity<>(playlistService.getAllCreatedPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/user-followed-playlists")
    public ResponseEntity<List<PlaylistDTO>> getAllFollowedPlaylists() {
        return new ResponseEntity<>(playlistService.getAllFollowedPlaylists(), HttpStatus.OK);
    }

    @PostMapping("/playlist")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody @Valid PlaylistCreateDTO playlistDTO) {
        return ResponseEntity.ok().body(playlistService.savePlaylist(playlistDTO));
    }

    @PutMapping("/playlist/{id}")
    public ResponseEntity<PlaylistDTO> updatePlaylist(@PathVariable("id") Integer id, @RequestBody PlaylistDTO playlistDTO) {
        return ResponseEntity.ok().body(playlistService.updatePlaylist(id, playlistDTO));
    }

    @PostMapping(params = {"idPlaylist", "idSong"}, value = "/playlist/song")
    public ResponseEntity<PlaylistDTO> addSongToPlaylist(@RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong) {
        return ResponseEntity.ok().body(playlistService.addSongToPlaylist(idPlaylist, idSong));
    }

    @DeleteMapping(params = {"idPlaylist", "idSong"}, value = "/playlist/song")
    public ResponseEntity<PlaylistDTO> removeSongFromPlaylist(@RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong) {
        return ResponseEntity.ok().body(playlistService.removeSongFromPlaylist(idPlaylist, idSong));
    }

    @PutMapping(params = {"idPlaylist", "idSong", "newPosition"}, value = "/playlist/song-order")
    public ResponseEntity<List<SongDTO>> changeSongsOrderPlaylist(@RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong, @RequestParam("newPosition") Integer newPosition) {
        return ResponseEntity.ok().body(playlistService.changeSongOrderInPlaylist(idPlaylist, idSong, newPosition));
    }

    @DeleteMapping("/playlist/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(playlistService.deletePlaylist(id));
    }


    @PostMapping(params = {"idPlaylist", "idAlbum"}, value = "/playlist/album")
    public ResponseEntity<PlaylistDTO> addAlbumToPlaylist(@RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idAlbum") Integer idAlbum) {
        return ResponseEntity.ok().body(playlistService.addAlbumToPlaylist(idPlaylist, idAlbum));
    }
}
