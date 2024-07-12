package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.services.SongService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
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

    @PostMapping("/{albumName}")
    public Song createSong(@RequestBody Song song, @PathVariable String albumName) {
        return songService.saveSong(song, albumName);
    }

    @PutMapping("/{name}/{albumName}")
    public Song updateSong(@PathVariable String name, @RequestBody Song song, @PathVariable String albumName) {
        Song existingSong = songService.findByTitle(name);
        if (existingSong != null) {
            song.setId(existingSong.getId());
            return songService.saveSong(song, albumName);
        } else {
            throw new EntityNotFoundException("Song with this name is not found: " + name);
        }
    }

    @DeleteMapping("/{name}/{albumName}")
    public void deleteSong(@PathVariable String name, @PathVariable String albumName) {
        Song existingSong = songService.findByTitle(name);
        if (existingSong != null) {
            songService.deleteSong(existingSong, albumName);
        } else {
            throw new EntityNotFoundException("Song with this name is not found: " + name);
        }
    }

}
