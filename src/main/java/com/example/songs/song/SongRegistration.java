package com.example.songs.song;

import com.example.songs.artist.Artist;

public record SongRegistration(
        String songName,
        Integer bpm,
        MusicKey musicKey,
        Artist artist,

        String lyrics
) {
}
