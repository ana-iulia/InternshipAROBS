package com.example.musify.controller;

import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.service.PlaylistService;
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
    public ResponseEntity<List<PlaylistDTO>> getAllCreatedPlaylists(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = headers.getFirst("authorization").split(" ");
        return new ResponseEntity<>(playlistService.getAllCreatedPlaylists(words[1]), HttpStatus.OK);
    }

    @GetMapping("/user-followed-playlists")
    public ResponseEntity<List<PlaylistDTO>> getAllFollowedPlaylists(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = headers.getFirst("authorization").split(" ");
        return new ResponseEntity<>(playlistService.getAllFollowedPlaylists(words[1]), HttpStatus.OK);
    }

    @PostMapping("/playlist")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid PlaylistCreateDTO playlistDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.savePlaylist(words[1], playlistDTO));
    }

    @PutMapping("/playlist/{id}")
    public ResponseEntity<PlaylistDTO> updatePlaylist(@RequestHeader("authorization") HttpHeaders headers, @PathVariable("id") Integer id, @RequestBody PlaylistDTO playlistDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.updatePlaylist(id, playlistDTO, words[1]));
    }

    @PostMapping(params = {"idPlaylist", "idSong"}, value = "/playlist/song")
    public ResponseEntity<PlaylistDTO> addSongToPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.addSongToPlaylist(idPlaylist, idSong, words[1]));
    }

    @DeleteMapping(params = {"idPlaylist", "idSong"}, value ="/playlist/song")
    public ResponseEntity<PlaylistDTO> removeSongFromPlaylist(@RequestHeader("authorization") HttpHeaders headers,@RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.removeSongFromPlaylist(idPlaylist, idSong, words[1]));
    }

    @PutMapping(params = {"idPlaylist", "idSong","newPosition"}, value ="/playlist/song-order")
    public ResponseEntity<List<SongDTO>> changeSongsOrderPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong, @RequestParam("newPosition") Integer newPosition) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.changeSongOrderInPlaylist(idPlaylist,idSong,newPosition, words[1]));
    }

    @DeleteMapping("/playlist/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(playlistService.deletePlaylist(id));
    }


    @PostMapping(params = {"idPlaylist", "idAlbum"}, value = "/playlist/album")
    public ResponseEntity<PlaylistDTO> addAlbumToPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idAlbum") Integer idAlbum) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.addAlbumToPlaylist(idPlaylist, idAlbum, words[1]));
    }
}
