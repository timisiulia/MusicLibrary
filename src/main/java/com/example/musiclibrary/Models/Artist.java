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
public class Artist {
    @Id
    private int id;
    private String name;
    @OneToMany
    private ArrayList<Album> albums;

    public Artist(int Id, String name, ArrayList<Album> albums) {
        this.id = Id;
        this.name = name;
        this.albums = albums;
    }

    public Artist() {

    }
}
