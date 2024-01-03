package com.example.songs.song;

import java.util.List;
import java.util.Optional;

public interface SongDao {

    Optional<List<Song>> getAllSongs();


    void deleteSong(Long id);

    void addSong(SongRegistration song);
}
