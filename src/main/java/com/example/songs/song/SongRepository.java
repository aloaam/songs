package com.example.songs.song;

import com.example.songs.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SongRepository extends JpaRepository<Song, Long> {


    //TODO - Alo:  findById and save should do the update.
    @Modifying
    @Transactional
    @Query("UPDATE Artist a SET a.name = :name WHERE a.id = :id")
    void updateArtist(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Song s " +
            "SET s.bpm = :bpm, " +
            "s.lyrics = :lyrics, " +
            "s.musicKey = :musicKey, " +
            "s.artist = :artist " +
            "WHERE s.id = :songId")
    void updateSong(@Param("songId") Long songId,
                    @Param("bpm") Integer bpm,
                    @Param("lyrics") String lyrics,
                    @Param("musicKey") MusicKey musicKey,
                    @Param("artist") Artist artist);


}
