package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.services.ArtistService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService=artistService;
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

//    @GetMapping("/{id}")
//    public Optional<Artist> getArtistById(@PathVariable int id) {
//        return artistService.getArtistById(id);
//    }

    @PostMapping
    public Artist createNewArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

//    @PutMapping("/{id}")
//    public Artist updateArtist(@PathVariable int id, @RequestBody Artist artist) {
//        artist.setId(id);
//        return artistService.saveArtist(artist);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteArtist(@PathVariable int id) {
//        artistService.deleteArtist(id);
//    }
@PutMapping("/{name}")
public Artist updateArtistByName(@PathVariable String name, @RequestBody Artist artist) {
    Artist existingArtist = artistService.findByName(name);
    if (existingArtist != null) {
        artist.setId(existingArtist.getId());
        return artistService.saveArtist(artist);
    } else {
        throw new EntityNotFoundException("Artist not found with name: " + name);
    }
}

    @DeleteMapping("/{name}")
    public void deleteArtistByName(@PathVariable String name) {
        Artist existingArtist = artistService.findByName(name);
        if (existingArtist != null) {
            artistService.deleteArtist(existingArtist.getId());
        } else {
            throw new EntityNotFoundException("Artist not found with name: " + name);
        }
    }
}
