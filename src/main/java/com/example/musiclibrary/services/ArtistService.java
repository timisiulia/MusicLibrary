package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
//
//    public Optional<Artist> getArtistById(int id) {
//        return artistRepository.findById(id);
//    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteArtist(int id) {
        artistRepository.deleteById(id);
    }

}
