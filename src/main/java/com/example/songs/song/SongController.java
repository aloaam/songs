package com.example.songs.song;

import com.example.songs.exceptions.NoContentRuntimeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/songs/")
public class SongController {

    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping
    public List<SongDto> getAllSongs() {

        Optional<List<Song>> allSongs = service.getAllSongs();

        if (allSongs.isEmpty()) {
            throw new NoContentRuntimeException("No data found in the DB");
        }

        return allSongs.get().stream()
                .map(song -> new SongDto(
                                song.getId(),
                                song.getSongName(),
                                song.getBpm(),
                                song.getMusicKey(),
                                song.getArtist(),
                                song.getLyrics()
                        )
                )
                .toList();
    }

    @GetMapping("{songId}")
    public SongDto getById(@PathVariable Long songId) {

        Optional<Song> song = service.getSongById(songId);

        if (song.isEmpty()) {
            throw new NoContentRuntimeException("No data found in the DB");
        }

        return new SongDto(
                song.get().getId(),
                song.get().getSongName(),
                song.get().getBpm(),
                song.get().getMusicKey(),
                song.get().getArtist(),
                song.get().getLyrics()
        );

    }

    @PostMapping
    public void insertSong(@RequestBody SongRegistration songRegistration) {
        service.registerSong(songRegistration);
    }

    @PutMapping("{songId}")
    public void updateSong(@PathVariable Long songId, @RequestBody SongRegistration songRegistration) {
        service.updateSong(songId, songRegistration);
    }

    @PutMapping("/lyrics/{songId}")
    public void updateLyrics(@PathVariable Long songId, @RequestBody LyricsUpdateRegistration lyricsRegistration) {
        service.updateLyrics(songId, lyricsRegistration);
    }

    @DeleteMapping("{id}")
    public void deleteSong(@PathVariable Long id) {
        service.deleteSong(id);
    }

}
