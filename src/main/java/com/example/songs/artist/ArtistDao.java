package com.example.songs.artist;

import java.util.List;
import java.util.Optional;

public interface ArtistDao {

    Optional<List<Artist>> getAll();

    void insertArtist(Artist artist);

    Optional<Artist> getArtistById(Long artistId);

    Optional<Artist> getArtistByName(String name);

    void deleteArtistById(Long id);
}
