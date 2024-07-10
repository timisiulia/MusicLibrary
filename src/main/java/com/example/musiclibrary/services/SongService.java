package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

//    public Optional<Song> getSongById(int id) {
//        return songRepository.findById(id);
//    }

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public void deleteSong(int id) {
        songRepository.deleteById(id);
    }
    public Song findByTitle(String title) {
        return songRepository.findByTitleContainingIgnoreCase(title).stream().findFirst().orElse(null);
    }

}
