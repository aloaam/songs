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

    @Override
    public Optional<Artist> getArtistById(Long artistId) {
        return repository.findById(artistId);
    }

    @Override
    public Optional<Artist> getArtistByName(String name) {
        return repository.findArtistByName(name);
    }

    @Override
    public void deleteArtistById(Long id) {
        repository.deleteById(id);
    }

}
