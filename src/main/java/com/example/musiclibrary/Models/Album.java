package com.example.musiclibrary.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Album {
    @Id
    private int id;
    private String title;
    @OneToMany
    private ArrayList<Song> songs;
    private String description;

    public Album(int id, String title, ArrayList<Song> songs, String description) {
        this.id = id;
        this.title = title;
        this.songs = songs;
        this.description = description;
    }

    public Album() {

    }
}

