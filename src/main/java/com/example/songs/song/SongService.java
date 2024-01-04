package com.example.songs.song;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongDao storage;


    public SongService(SongDao storage) {
        this.storage = storage;
    }

    public Optional<List<Song>> getAllSongs() {
        return storage.getAllSongs();
    }

    public void registerSong(SongRegistration song) {
        storage.addSong(song);
    }

    public void deleteSong(Long id) {
        storage.deleteSong(id);
    }

    public void updateSong(Long songId, SongRegistration songRegistration) {
        storage.updateSong(songId, songRegistration);
    }

    public void updateLyrics(Long songId, LyricsUpdateRegistration lyricsRegistration) {
        storage.updateLyrics(songId, lyricsRegistration);
    }

    public Optional<Song> getSongById(Long songId) {
        return storage.getSongById(songId);
    }
}
