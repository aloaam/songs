package com.example.songs.song;

import jakarta.persistence.*;

@Entity(name = "Song")
@Table(name = "song")
public class Song {

    @Id
    @SequenceGenerator(name = "song_sequence", sequenceName = "song_sequence", allocationSize = 1)
    @GeneratedValue(generator = "song_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MusicKey originalMusicKey;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String artist;

    @Column(nullable = false)
    private Integer bpm;

    private String lyrics;

    public Song() {
    }

}
