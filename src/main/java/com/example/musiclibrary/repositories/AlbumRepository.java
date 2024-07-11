package com.example.musiclibrary.repositories;

import com.example.musiclibrary.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByTitleContainingIgnoreCase(String title);
}
