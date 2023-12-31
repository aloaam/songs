package com.example.songs.artist;

import com.example.songs.exceptions.NoContentRuntimeException;
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
            throw new NoContentRuntimeException(String.format("Artist with name: %s already exists.", artistName));
        }
        storage.insertArtist(artist);
    }

    public void deleteArtistById(Long artistId) {
        storage.deleteArtistById(artistId);
        throw new NoContentRuntimeException(String.format("Artist with id: %s doesn't exist.", artistId));
    }

    public boolean existArtistByName(String name) {
        Optional<Artist> artist = storage.getArtistByName(name);
        return artist.isPresent();
    }

    public boolean existArtistById(Long id) {
        Optional<Artist> artist = storage.getArtistById(id);
        return artist.isPresent();
    }

    public void updateArtist(ArtistDto artistDto) {
        storage.updateArtist(artistDto);
    }
}
