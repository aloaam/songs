package com.example.songs.song;

import com.example.songs.artist.Artist;

public record SongDto(
        Long id,
        String songName,
        Integer bpm,
        MusicKey musicKey,
        Artist artist
) {
}
