package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.services.AlbumService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @PostMapping("/{artistName}")
    public Album AddNewAlbum(@RequestBody Album album, @PathVariable String artistName) {
        return albumService.saveAlbum(album, artistName);
    }

    @PutMapping("/{title}/{artistName}")
    public Album updateAlbum(@PathVariable String title, @RequestBody Album album, @PathVariable String artistName) {
        Album existingAlbum = albumService.findByTitle(title);
        if (existingAlbum != null) {
            album.setId(existingAlbum.getId());
            return albumService.saveAlbum(album, artistName);

        } else {
            throw new EntityNotFoundException("Album with this title was not found: " + title);
        }
    }

    @DeleteMapping("/{title}")
    public void deleteAlbum(@PathVariable String title) {
        Album existingAlbum = albumService.findByTitle(title);
        if (existingAlbum != null) {
            albumService.deleteAlbum(existingAlbum.getId());
        } else {
            throw new EntityNotFoundException("Album with this title was not found: " + title);
        }
    }


}
