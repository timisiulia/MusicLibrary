package com.example.musiclibrary.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "albums")
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;

    @Column(name = "description")
    private String description;

    public Album() {}

    public Album(int id, String title, List<Song> songs, String description) {
        this.id = id;
        this.title = title;
        this.songs = songs;
        this.description = description;
    }
}
