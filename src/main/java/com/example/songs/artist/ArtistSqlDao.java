package com.example.songs.artist;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistSqlDao implements ArtistDao {

    private final ArtistRepository repository;

    public ArtistSqlDao(ArtistRepository repository) {
        this.repository = repository;
    }

    public Optional<List<Artist>> getAll() {
        return Optional.of(repository.findAll());
    }

    @Override
    public void insertArtist(Artist artist) {
        repository.save(artist);
    }

}
