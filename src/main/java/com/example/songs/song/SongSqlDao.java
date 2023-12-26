package com.example.songs.song;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SongSqlDao implements SongDao {

    private final SongRepository repository;

    public SongSqlDao(SongRepository repository) {
        this.repository = repository;
    }

    public Optional<List<Song>> getAllSongs() {
        return Optional.of(repository.findAll());
    }

}
