package com.example.songs.performancemeasure;

import com.example.songs.song.Song;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    private final PerformanceDao storage;

    public PerformanceService(PerformanceDao storage) {
        this.storage = storage;
    }

    public Optional<List<Performance>> getAllPerformances() {
        return storage.getAllPerformances();
    }

    public void registerPerformance(PerformanceRegistration registration) {
        storage.addPerformance(registration);
    }

    public void deletePerformance(Long id) {
        storage.deletePerformance(id);
    }

    public void updatePerformance(Long id, PerformanceRegistration registration) {
        storage.updatePerformance(id, registration);
    }

    public Optional<Performance> getPerformanceById(Long id) {
        return storage.getPerformanceById(id);
    }

    public Optional<List<Performance>> getPerformancesBySong(Song song) {
        return storage.getPerformanceBySong(song);
    }
}
