package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.repositories.AlbumRepository;
import com.example.musiclibrary.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public void deleteSong(Song s, String albumName) {
        Album album = albumRepository.findByTitleContainingIgnoreCase(albumName).get(0);
        album.getSongs().remove(s);
        albumRepository.save(album);
        songRepository.delete(s);
    }

    public Song findByTitle(String title) {
        return songRepository.findByTitleContainingIgnoreCase(title).stream().findFirst().orElse(null);
    }

}
