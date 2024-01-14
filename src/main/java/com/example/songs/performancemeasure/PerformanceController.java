package com.example.songs.performancemeasure;

import com.example.songs.exceptions.NoContentRuntimeException;
import com.example.songs.song.Song;
import com.example.songs.song.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/performances/")
public class PerformanceController {

    private final PerformanceService service;
    private final SongService songService;

    public PerformanceController(PerformanceService service, SongService songService) {
        this.service = service;
        this.songService = songService;
    }

    @GetMapping
    public List<PerformanceDto> getAllPerformances() {

        Optional<List<Performance>> allSongs = service.getAllPerformances();

        if (allSongs.isEmpty()) {
            throw new NoContentRuntimeException("No data found in the DB");
        }

        return allSongs.get().stream()
                .map(song -> new PerformanceDto(
                                song.getId(),
                                song.getSong().getId(),
                                song.getMeasure(),
                                song.getPerformanceComment()
                        )
                )
                .toList();
    }


    @GetMapping("/songs/{songId}")
    public List<PerformanceDto> getBySongId(@PathVariable Long songId) {


        Optional<Song> song = songService.getSongById(songId);
        if (song.isEmpty()) {
            throw new NoContentRuntimeException(
                    String.format(
                            "The song to add the id to was not found in the DB. Id of the song looked for: %s",
                            songId)
            );
        }
        Optional<List<Performance>> performances = service.getPerformancesBySong(song.get());

        if (performances.isEmpty()) {
            throw new NoContentRuntimeException(
                    String.format("No data found in the DB, for songId: %s", songId));
        }

        return performances.get().stream()
                .map(p ->
                        new PerformanceDto(
                                p.getId(),
                                p.getSong().getId(),
                                p.getMeasure(),
                                p.getPerformanceComment()
                        )
                ).toList();

    }

    @GetMapping("{id}")
    public PerformanceDto getById(@PathVariable Long id) {

        Optional<Performance> performance = service.getPerformanceById(id);

        if (performance.isEmpty()) {
            throw new NoContentRuntimeException("No data found in the DB");
        }

        return new PerformanceDto(
                performance.get().getId(),
                performance.get().getSong().getId(),
                performance.get().getMeasure(),
                performance.get().getPerformanceComment()
        );

    }

    @PostMapping
    public void insertPerformance(@RequestBody PerformanceRegistration registration) {
        service.registerPerformance(registration);
    }

    @PutMapping("{id}")
    public void updatePerformance(@PathVariable Long id, @RequestBody PerformanceRegistration performanceRegistration) {
        service.updatePerformance(id, performanceRegistration);
    }


    @DeleteMapping("{id}")
    public void deleteSong(@PathVariable Long id) {
        service.deletePerformance(id);
    }

}
