package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.services.SongService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

//    @GetMapping("/{id}")
//    public Optional<Song> getSongById(@PathVariable int id) {
//        return songService.getSongById(id);
//    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

//    @PutMapping("/{id}")
//    public Song updateSong(@PathVariable int id, @RequestBody Song song) {
//        song.setId(id);
//        return songService.saveSong(song);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteSong(@PathVariable int id) {
//        songService.deleteSong(id);
//    }
@PutMapping("/{name}")
public Song updateSongByName(@PathVariable String name, @RequestBody Song song) {
    Song existingSong = songService.findByTitle(name);
    if (existingSong != null) {
        song.setId(existingSong.getId());
        return songService.saveSong(song);
    } else {
        throw new EntityNotFoundException("Song not found with name: " + name);
    }
}

    @DeleteMapping("/{name}")
    public void deleteSongByName(@PathVariable String name) {
        Song existingSong = songService.findByTitle(name);
        if (existingSong != null) {
            songService.deleteSong(existingSong.getId());
        } else {
            throw new EntityNotFoundException("Song not found with name: " + name);
        }
    }

}
