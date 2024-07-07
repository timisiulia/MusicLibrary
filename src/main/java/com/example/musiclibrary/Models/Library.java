package com.example.musiclibrary.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
@Getter
@Setter
public class Library {
    @Id
    private int id;
    @OneToMany
    private ArrayList<Artist> artists;

    public Library(int Id, ArrayList<Artist> artists) {
        this.id = Id;
        this.artists = artists;
    }

    public Library() {

    }
}
