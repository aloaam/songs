package com.example.songs.performancemeasure;

import com.example.songs.exceptions.NoContentRuntimeException;
import com.example.songs.song.Song;
import com.example.songs.song.SongService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerformanceSqlDao implements PerformanceDao {

    private final PerformanceRepository repository;
    private final SongService songService;

    public PerformanceSqlDao(PerformanceRepository repository, SongService songService) {
        this.repository = repository;
        this.songService = songService;
    }

    public Optional<List<Performance>> getAllPerformances() {
        return Optional.of(repository.findAll());
    }

    @Override
    public void addPerformance(PerformanceRegistration registration) {

        Optional<Song> song = songService.getSongById(registration.songId());
        if (song.isEmpty()) {
            throw new NoContentRuntimeException(
                    String.format(
                            "The song to add the id to was not found in the DB. Id of the song looked for: %s",
                            registration.songId())
            );
        }

        Performance performance = new Performance(
                song.get(),
                registration.measure(),
                registration.comment().orElse(null),
                registration.grade()
        );
        repository.save(performance);
    }

    @Override
    public void updatePerformance(Long id, PerformanceRegistration registration) {

        Optional<Song> song = songService.getSongById(registration.songId());
        if (song.isEmpty()) {
            throw new NoContentRuntimeException(
                    String.format(
                            "The song to add the id to was not found in the DB. Id of the song looked for: %s",
                            registration.songId())
            );
        }
        repository.updatePerformance(
                id,
                song.get(),
                registration.measure(),
                registration.comment().orElse(null)
        );
    }

    @Override
    public Optional<Performance> getPerformanceById(Long songId) {
        return repository.findById(songId);
    }

    @Override
    public Optional<List<Performance>> getPerformanceBySong(Song song) {
        return repository.findPerformancesBySong(song);
    }


    @Override
    public void deletePerformance(Long id) {
        repository.deleteById(id);
    }

}
