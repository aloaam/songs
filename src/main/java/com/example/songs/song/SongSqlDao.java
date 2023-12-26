package com.example.songs.song;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongSqlDao implements SongDao {

    private final SongRepository repository;

    public SongSqlDao(SongRepository repository) {
        this.repository = repository;
    }

    public List<Song> getAllSongs() {
        return repository.findAll();
    }

}
