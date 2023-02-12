package com.example.songs.songPerformance;

import com.example.songs.song.MusicKey;
import com.example.songs.song.Song;
import jakarta.persistence.*;

/**
 * This component models how the interpreter (the final user) performs a song.
 */
@Entity(name = "SongPerformance")
@Table(name = "song_performance")
public class SongPerformance {

    @Id
    @SequenceGenerator(name = "song_performance_sequence", sequenceName = "song_performance_sequence", allocationSize = 1)
    @GeneratedValue(generator = "song_performance_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "song_id", foreignKey = @ForeignKey(name = "song_fk"))
    private Song songId;

    @Enumerated(EnumType.STRING)
    private MusicKey musicKey;

    @Column(nullable = false)
    private Integer lyricsScore;

    private Integer structureScore;

    @Column(nullable = false)
    private Integer soloScore;

    @Column(nullable = false)
    private String lyricsScoreComment;

    private String structureScoreComment;

    @Column(nullable = false)
    private String soloScoreComment;

    public SongPerformance() {
    }


}
