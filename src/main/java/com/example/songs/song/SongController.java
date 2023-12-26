package com.example.songs.song;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/songs/")
public class SongController {

    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping
    public @ResponseBody List<SongDto> getAllSongs() {
        //TODO - Alo: return Optional and Throw Error
        List<SongDto> songDtos = service.getAllSongs().stream()
                .map(song -> new SongDto(
                                song.getId(),
                                song.getSongName(),
                                song.getBpm(),
                                song.getMusicKey(),
                                song.getArtist()
                        )
                )
                .toList();
        return songDtos;
    }

}
