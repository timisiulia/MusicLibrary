package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.repositories.AlbumRepository;
import com.example.musiclibrary.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private AlbumRepository albumRepository;
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }


    public Song saveSong(Song song, String albumName) {
        Album album = albumRepository.findByTitleContainingIgnoreCase(albumName).get(0);
        album.getSongs().add(song);
        albumRepository.save(album);
        return songRepository.save(song);
    }

    public void deleteSong(int id) {
        songRepository.deleteById(id);
    }

    public Song findByTitle(String title) {
        return songRepository.findByTitleContainingIgnoreCase(title).stream().findFirst().orElse(null);
    }

}
