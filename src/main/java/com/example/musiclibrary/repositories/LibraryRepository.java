package com.example.musiclibrary.repositories;

import com.example.musiclibrary.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}