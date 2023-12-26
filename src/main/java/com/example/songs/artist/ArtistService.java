package com.example.songs.artist;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistDao storage;


    public ArtistService(ArtistDao storage) {
        this.storage = storage;
    }

    public Optional<List<Artist>> getAllArtists() {
        return storage.getAll();
    }

    public void insertArtist(Artist artist) {

        String artistName = artist.getName();
        if (existArtistByName(artistName)) {
            throw new RuntimeException(String.format("Artist with name: %s already exists.", artistName));
        }

        storage.insertArtist(artist);
    }

    public boolean existArtistByName(String name) {
        Optional<Artist> artist = storage.getArtistByName(name);
        return artist.isPresent();
    }
}
