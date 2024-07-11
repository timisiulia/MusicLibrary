package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.Library;
import com.example.musiclibrary.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Library createNewLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable int id) {
        libraryService.deleteLibrary(id);
    }

}
