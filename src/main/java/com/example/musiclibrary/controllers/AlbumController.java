package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumservice, AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Optional<Album> getAlbumById(@PathVariable int id) {
        return albumService.getAlbumById(id);
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable int id, @RequestBody Album album) {
        album.setId(id);
        return albumService.saveAlbum(album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable int id) {
        albumService.deleteAlbum(id);
    }

    @GetMapping("/search")
    public List<Album> searchAlbums(@RequestParam String query) {
        return albumService.searchAlbums(query);
    }
}
