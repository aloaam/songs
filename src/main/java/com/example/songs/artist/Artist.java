package com.example.songs.artist;

import jakarta.persistence.*;

@Entity(name = "Artist")
@Table(name = "artist")
public class Artist {

    @Id
    @SequenceGenerator(name = "artist_sequence", sequenceName = "artist_sequence", allocationSize = 1)
    @GeneratedValue(generator = "artist_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }
}
