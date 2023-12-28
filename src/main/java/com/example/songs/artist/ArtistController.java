package com.example.songs.artist;

import com.example.songs.exceptions.NoContentRuntimeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/artists/")
public class ArtistController {

    private final ArtistService service;

    public ArtistController(ArtistService service) {
        this.service = service;
    }

    @GetMapping
    public List<ArtistDto> getAllArtists() {

        Optional<List<Artist>> allArtists = service.getAllArtists();

        if (allArtists.isEmpty()) {
            throw new NoContentRuntimeException("No data found in the DB");
        }

        return allArtists.get().stream()
                .map(artist -> new ArtistDto(
                                artist.getId(),
                                artist.getName()
                        )
                )
                .toList();
    }

    @PostMapping
    public void insertArtist(@RequestBody ArtistDto artist) {
        service.insertArtist(new Artist(artist.artistName()));
    }

    @DeleteMapping("{id}")
    public void deleteArtistById(@PathVariable Long id) {
        service.deleteArtistById(id);
    }

}
