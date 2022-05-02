package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.PlaylistCreateDTO;
import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.model.Playlist;
import com.example.musify.service.AlbumService;
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
@RequestMapping("/musify/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<PlaylistDTO>> getAll() {
        return new ResponseEntity<>(playlistService.getAllPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/publicPlaylists")
    public ResponseEntity<List<PlaylistDTO>> getAllPublicPlaylists() {
        return new ResponseEntity<>(playlistService.getAllPublicPlaylists(), HttpStatus.OK);
    }

    @GetMapping("/myCreatedPlaylists")
    public ResponseEntity<List<PlaylistDTO>> getAllCreatedPlaylists(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = headers.getFirst("authorization").split(" ");
        return new ResponseEntity<>(playlistService.getAllCreatedPlaylists(words[1]), HttpStatus.OK);
    }

    @GetMapping("/myFollowedPlaylists")
    public ResponseEntity<List<PlaylistDTO>> getAllFollowedPlaylists(@RequestHeader("authorization") HttpHeaders headers) {
        String[] words = headers.getFirst("authorization").split(" ");
        return new ResponseEntity<>(playlistService.getAllFollowedPlaylists(words[1]), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestBody @Valid PlaylistCreateDTO playlistDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.savePlaylist(words[1], playlistDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlaylistDTO> updatePlaylist(@RequestHeader("authorization") HttpHeaders headers, @PathVariable("id") Integer id, @RequestBody PlaylistDTO playlistDTO) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.updatePlaylist(id, playlistDTO, words[1]));
    }

    @PutMapping(params = {"idPlaylist", "idSong"}, value = "/addSong")
    public ResponseEntity<PlaylistDTO> addSongToPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.addSongToPlaylist(idPlaylist, idSong, words[1]));
    }

    @PutMapping(params = {"idPlaylist", "idSong"}, value ="/removeSong")
    public ResponseEntity<PlaylistDTO> removeSongFromPlaylist(@RequestHeader("authorization") HttpHeaders headers,@RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.removeSongFromPlaylist(idPlaylist, idSong, words[1]));
    }

    @PutMapping(params = {"idPlaylist", "idSong","newPosition"}, value ="/changeSongOrder")
    public ResponseEntity<List<SongDTO>> changeSongsOrderPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idSong") Integer idSong, @RequestParam("newPosition") Integer newPosition) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.changeSongOrderInPlaylist(idPlaylist,idSong,newPosition, words[1]));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(playlistService.deletePlaylist(id));
    }


    @PutMapping(params = {"idPlaylist", "idAlbum"}, value = "/addAlbum")
    public ResponseEntity<PlaylistDTO> addAlbumToPlaylist(@RequestHeader("authorization") HttpHeaders headers, @RequestParam("idPlaylist") Integer idPlaylist, @RequestParam("idAlbum") Integer idAlbum) {
        String[] words = headers.getFirst("authorization").split(" ");
        return ResponseEntity.ok().body(playlistService.addAlbumToPlaylist(idPlaylist, idAlbum, words[1]));
    }
}
