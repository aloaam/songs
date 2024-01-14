package com.example.songs.performancemeasure;

import com.example.songs.song.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.ToString;

/**
 * By performance, artistic performance is meant, i.e., how well a song is interpreted in its different dimensions,
 * like, how well you know the lyrics or the song structure.
 **/
@Getter
@ToString
@Entity(name = "Performance")
@Table(name = "performance")
public class Performance {

    //TODO - Alo: need to implement multi-user, check out this link:
    // https://stackoverflow.com/questions/22954787/hibernate-with-two-foreign-keys-from-same-table-annotation.


    @Id
    @SequenceGenerator(name = "performance_sequence", sequenceName = "performance_sequence", allocationSize = 1)
    @GeneratedValue(generator = "performance_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "song_id", foreignKey = @ForeignKey(name = "song_fk"))
    private Song song;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PerformanceMeasureType measure;

    @Column(name = "performance_comment")
    private String performanceComment;

    @Column(name = "grade")
    @Min(0)
    @Max(10)
    private Short grade;

    public Performance(Song song, PerformanceMeasureType measure, String performanceComment, Short grade) {
        this.song = song;
        this.measure = measure;
        this.performanceComment = performanceComment;
        this.grade = grade;
    }

    public Performance() {
    }


}
