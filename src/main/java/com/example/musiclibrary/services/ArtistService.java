package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll().stream().toList();
    }

    public Artist getArtistByName(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name).get(0);
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteArtist(int id) {
        artistRepository.deleteById(id);
    }
    public Artist findByName(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name).stream().findFirst().orElse(null);
    }

}
