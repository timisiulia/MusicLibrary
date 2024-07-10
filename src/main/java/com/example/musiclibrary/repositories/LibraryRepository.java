package com.example.musiclibrary.repositories;

import com.example.musiclibrary.models.Library;
import com.example.musiclibrary.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}