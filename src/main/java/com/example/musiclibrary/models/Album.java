package com.example.musiclibrary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> traks;

//    public Album() {}
//
//    public Album(int id, String title, List<Song> traks, String description) {
//        this.id = id;
//        this.title = title;
//        this.traks = traks;
//        this.description = description;
//    }
}
