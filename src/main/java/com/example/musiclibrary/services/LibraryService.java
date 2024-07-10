package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Library;
import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

//    public Optional<Library> getLibraryById(int id) {
//        return libraryRepository.findById(id);
//    }

    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibrary(int id) {
        libraryRepository.deleteById(id);
    }


}
