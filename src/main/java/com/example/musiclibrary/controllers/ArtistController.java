package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Optional<Artist> getArtistById(@PathVariable int id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
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

//    @GetMapping("/search")
//    public List<Artist> searchArtists(@RequestParam String query) {
//        return artistService.searchArtists(query);
//    }
}
