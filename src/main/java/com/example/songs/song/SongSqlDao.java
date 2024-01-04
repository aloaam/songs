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

    @Override
    public void addSong(SongRegistration songRegistration) {
        Song song = new Song(
                songRegistration.musicKey(),
                songRegistration.songName(),
                songRegistration.artist(),
                songRegistration.bpm()
        );
        repository.save(song);
    }

    @Override
    public void updateSong(Long songId, SongRegistration songRegistration) {
        repository.updateSong(
                songId,
                songRegistration.bpm(),
                songRegistration.lyrics(),
                songRegistration.musicKey(),
                songRegistration.artist()
        );
    }

    @Override
    public void updateLyrics(Long songId, LyricsUpdateRegistration lyricsRegistration) {
        repository.updateLyrics(songId, lyricsRegistration.lyrics());
    }

    @Override
    public Optional<Song> getSongById(Long songId) {
        return repository.findById(songId);
    }

    @Override
    public void deleteSong(Long id) {
        repository.deleteById(id);
    }

}
