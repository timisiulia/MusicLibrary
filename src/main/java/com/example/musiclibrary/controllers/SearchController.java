package com.example.musiclibrary.controllers;

import com.example.musiclibrary.models.SearchAllEntity;
import com.example.musiclibrary.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<SearchAllEntity> search(@RequestParam String query) {
        return searchService.search(query);
    }
}
