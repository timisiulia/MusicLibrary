package com.example.musiclibrary.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "libraries")
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Artist> artists;

    public Library() {}

//    public Library(int id, List<Artist> artists) {
//        this.id = id;
//        this.artists = artists;
//    }
}
