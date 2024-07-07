package com.example.musiclibrary.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Song {
    @Id
    private int id;
    private String title;
    private String length;

    public Song(int id, String title, String length) {
        this.id = id;
        this.title = title;
        this.length = length;
    }

    public Song() {

    }

}
