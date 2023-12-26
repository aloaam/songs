package com.example.songs;

import com.example.songs.artist.Artist;
import com.example.songs.song.Song;
import com.example.songs.song.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SongsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongsApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup(SongRepository songRepository) {
        return args -> {

            System.out.println("Hello!");
            List<Song> allSongs = songRepository.findAll();
            Song song = allSongs.get(0);

            Artist artist = song.getArtist();

            System.out.println(artist);
            System.out.println(song);
        };

    }
}