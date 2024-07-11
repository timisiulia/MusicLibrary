package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.repositories.AlbumRepository;
import com.example.musiclibrary.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    @Autowired
    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }


    public Album saveAlbum(Album album, String artistName) {
        Artist artist = artistRepository.findByNameContainingIgnoreCase(artistName).get(0);
        artist.getAlbums().add(album);
        artistRepository.save(artist);
        return albumRepository.save(album);
    }

    public void deleteAlbum(int id) {
        albumRepository.deleteById(id);
    }

    public Album findByTitle(String title) {
        return albumRepository.findByTitleContainingIgnoreCase(title).stream().findFirst().orElse(null);
    }


}
