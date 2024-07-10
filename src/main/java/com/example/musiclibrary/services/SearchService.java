package com.example.musiclibrary.services;

import com.example.musiclibrary.dto.SearchAll;
import com.example.musiclibrary.models.Album;
import com.example.musiclibrary.models.Artist;
import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.repositories.AlbumRepository;
import com.example.musiclibrary.repositories.ArtistRepository;
import com.example.musiclibrary.repositories.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<SearchAll> search(String query) {
        List<SearchAll> results = new ArrayList<>();

        List<Album> albums = albumRepository.findByTitleContainingIgnoreCase(query);
        results.addAll(albums.stream()
                .map(album -> new SearchAll("Album", album.getTitle()))
                .collect(Collectors.toList()));

        List<Artist> artists = artistRepository.findByNameContainingIgnoreCase(query);
        results.addAll(artists.stream()
                .map(artist -> new SearchAll("Artist", artist.getName()))
                .collect(Collectors.toList()));



        List<Song> songs = songRepository.findByTitleContainingIgnoreCase(query);
        results.addAll(songs.stream()
                .map(song -> new SearchAll("Song", song.getTitle()))
                .collect(Collectors.toList()));

        return results;
    }
}
