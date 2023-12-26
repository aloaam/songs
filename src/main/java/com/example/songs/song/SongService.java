package com.example.songs.song;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongDao storage;


    public SongService(SongDao storage) {
        this.storage = storage;
    }

    public List<Song> getAllSongs() {
        return storage.getAllSongs();
    }

}
