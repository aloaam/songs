package com.example.songs.song;

import com.example.songs.exceptions.NoContentRuntimeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                                song.getArtist()
                        )
                )
                .toList();
    }

}
