package com.example.songs.song;

import com.example.songs.artist.Artist;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity(name = "Song")
@Table(name = "song")
public class Song {

    @Id
    @SequenceGenerator(name = "song_sequence", sequenceName = "song_sequence", allocationSize = 1)
    @GeneratedValue(generator = "song_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MusicKey musicKey;

    @Column(name = "song_name")
    private String songName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", foreignKey = @ForeignKey(name = "artist_fk"))
    private Artist artist;

    @Column(name = "bpm")
    private Integer bpm;

    @Column(name = "lyrics")
    private String lyrics;

    public Song(MusicKey musicKey, String songName, Artist artist, Integer bpm) {
        this.musicKey = musicKey;
        this.songName = songName;
        this.artist = artist;
        this.bpm = bpm;
    }

    public Song() {

    }
}
