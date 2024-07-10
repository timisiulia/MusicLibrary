package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Library;
import com.example.musiclibrary.models.Song;
import com.example.musiclibrary.services.LibraryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/libraries")
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

//    @GetMapping("/{id}")
//    public Optional<Library> getLibraryById(@PathVariable int id) {
//        return libraryService.getLibraryById(id);
//    }

    @PostMapping
    public Library createNewLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable int id, @RequestBody Library library) {
        library.setId(id);
        return libraryService.saveLibrary(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable int id) {
        libraryService.deleteLibrary(id);
    }

}
