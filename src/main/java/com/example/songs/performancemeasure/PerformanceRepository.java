package com.example.songs.performancemeasure;

import com.example.songs.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {


    //TODO - Alo:  findById and save should do the update.
    @Modifying
    @Transactional
    @Query("UPDATE Performance p " +
            "SET p.song = :song, " +
            "p.measure = :measure, " +
            "p.performanceComment = :comment " +
            "WHERE p.id = :performanceId")
    void updatePerformance(@Param("performanceId") Long performanceId,
                           @Param("song") Song song,
                           @Param("measure") PerformanceMeasureType measure,
                           @Param("comment") String comment);


    @Modifying
    @Transactional
    @Query("UPDATE Performance p SET p.performanceComment = :comment WHERE p.id = :id")
    void updateComment(@Param("id") Long songId, @Param("comment") String lyrics);

    @Query("SELECT p FROM Performance p WHERE p.song = :song")
    Optional<List<Performance>> findPerformancesBySong(@Param("song") Song song);

}
