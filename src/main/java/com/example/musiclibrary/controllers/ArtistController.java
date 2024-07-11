package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.services.ArtistService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService=artistService;
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Artist> getAllArtists() {

        return artistService.getAllArtists();
    }

    @GetMapping("/{name}")
    public Artist getArtistByName(@PathVariable String name) {
        return artistService.getArtistByName(name);
    }

    @PostMapping
    public Artist createNewArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    @PutMapping("/{name}")
    public Artist updateArtist(@PathVariable String name, @RequestBody Artist artist) {
        Artist existingArtist = artistService.findByName(name);
        if (existingArtist != null) {
            artist.setId(existingArtist.getId());
            return artistService.saveArtist(artist);
        } else {
            throw new EntityNotFoundException("Artist with this name is not found: " + name);
        }
    }

    @DeleteMapping("/{name}")
    public void deleteArtist(@PathVariable String name) {
        Artist existingArtist = artistService.findByName(name);
        if (existingArtist != null) {
            artistService.deleteArtist(existingArtist.getId());
        } else {
            throw new EntityNotFoundException("Artist with this name is not found " + name);
        }
    }
}
