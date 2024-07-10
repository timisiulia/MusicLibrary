package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artist")
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

    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable int id, @RequestBody Artist artist) {
        artist.setId(id);
        return artistService.saveArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable int id) {
        artistService.deleteArtist(id);
    }
}
