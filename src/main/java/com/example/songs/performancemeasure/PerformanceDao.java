package com.example.songs.performancemeasure;

import com.example.songs.song.Song;

import java.util.List;
import java.util.Optional;

public interface PerformanceDao {

    Optional<List<Performance>> getAllPerformances();

    void deletePerformance(Long id);

    void addPerformance(PerformanceRegistration song);

    void updatePerformance(Long id, PerformanceRegistration performanceRegistration);


    Optional<Performance> getPerformanceById(Long songId);

    Optional<List<Performance>> getPerformanceBySong(Song song);
}
