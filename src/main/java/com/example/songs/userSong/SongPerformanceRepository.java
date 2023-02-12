package com.example.songs.userSong;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongPerformanceRepository extends JpaRepository<SongPerformance, Long> {
}
