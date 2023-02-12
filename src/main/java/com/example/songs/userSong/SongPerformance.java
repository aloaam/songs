package com.example.songs.userSong;

import com.example.songs.song.MusicKey;
import jakarta.persistence.*;

@Entity(name = "SongPerformance")
@Table(name = "song_performance")
public class SongPerformance {

    @Id
    @SequenceGenerator(name = "song_performance_sequence", sequenceName = "song_performance_sequence", allocationSize = 1)
    @GeneratedValue(generator = "song_performance_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MusicKey musicKey;

    private Integer lyricsScore;

    private Integer structureScore;

    private Integer soloScore;

    private String lyricsScoreComment;

    private String structureScoreComment;

    private String soloScoreComment;

}
