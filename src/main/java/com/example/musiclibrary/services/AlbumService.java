package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService( AlbumRepository albumRepository){
        this.albumRepository=albumRepository;
    }
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

//    public Optional<Album> getAlbumById(int id) {
//        return albumRepository.findById(id);
//    }
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(int id) {
        albumRepository.deleteById(id);
    }
    public Album findByTitle(String title) {
        return albumRepository.findByTitleContainingIgnoreCase(title).stream().findFirst().orElse(null);
    }


}
