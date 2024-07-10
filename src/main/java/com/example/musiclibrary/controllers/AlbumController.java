package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.services.AlbumService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController( AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

//    @GetMapping("/{id}")
//    public Optional<Album> getAlbumById(@PathVariable int id) {
//        return albumService.getAlbumById(id);
//    }
    @PostMapping
    public Album createNewAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

//    @PutMapping("/{id}")
//    public Album updateAlbum(@PathVariable int id, @RequestBody Album album) {
//        album.setId(id);
//        return albumService.saveAlbum(album);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAlbum(@PathVariable int id) {
//        albumService.deleteAlbum(id);
//    }
@PutMapping("/{title}")
public Album updateAlbumByTitle(@PathVariable String title, @RequestBody Album album) {
    Album existingAlbum = albumService.findByTitle(title);
    if (existingAlbum != null) {
        album.setId(existingAlbum.getId());
        return albumService.saveAlbum(album);
    } else {
        throw new EntityNotFoundException("Album not found with title: " + title);
    }
}

    @DeleteMapping("/{title}")
    public void deleteAlbumByTitle(@PathVariable String title) {
        Album existingAlbum = albumService.findByTitle(title);
        if (existingAlbum != null) {
            albumService.deleteAlbum(existingAlbum.getId());
        } else {
            throw new EntityNotFoundException("Album not found with title: " + title);
        }
    }


}
