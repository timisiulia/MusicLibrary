package com.example.musiclibrary.repositories;

import com.example.musiclibrary.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer > {
    List<Song> findByTitleContainingIgnoreCase(String title);
}
