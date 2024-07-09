package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Optional<Song> getSongById(@PathVariable int id) {
        return songService.getSongById(id);
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable int id, @RequestBody Song song) {
        song.setId(id);
        return songService.saveSong(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
    }

//    @GetMapping("/search")
//    public List<Song> searchSongs(@RequestParam String query) {
//        return songService.searchSongs(query);
//    }
}
