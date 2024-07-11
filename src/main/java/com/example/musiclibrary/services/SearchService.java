package com.example.musiclibrary.services;

import com.example.musiclibrary.models.SearchAllEntity;
import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.repositories.AlbumRepository;
import com.example.musiclibrary.repositories.ArtistRepository;
import com.example.musiclibrary.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class SearchService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public SearchService(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public List<SearchAllEntity> search(String query) {

        List<Album> albums = albumRepository.findByTitleContainingIgnoreCase(query);
        List<SearchAllEntity> results = new ArrayList<>(albums.stream()
                .map(album -> new SearchAllEntity("Album", album.getTitle()))
                .toList());

        List<Artist> artists = artistRepository.findByNameContainingIgnoreCase(query);
        results.addAll(artists.stream()
                .map(artist -> new SearchAllEntity("Artist", artist.getName()))
                .toList());


        List<Song> songs = songRepository.findByTitleContainingIgnoreCase(query);
        results.addAll(songs.stream()
                .map(song -> new SearchAllEntity("Song", song.getTitle()))
                .toList());

        return results;
    }
}
