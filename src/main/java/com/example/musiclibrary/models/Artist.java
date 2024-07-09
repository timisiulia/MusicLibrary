package com.example.musiclibrary.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artists")
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Album> albums;

    public Artist() {}

//    public Artist(int id, String name, List<Album> albums) {
//        this.id = id;
//        this.name = name;
//        this.albums = albums;
//    }
}
