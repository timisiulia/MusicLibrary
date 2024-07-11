package com.example.musiclibrary.services;

import com.example.musiclibrary.models.Library;
import com.example.musiclibrary.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibrary(int id) {
        libraryRepository.deleteById(id);
    }

}
