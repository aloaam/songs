package com.example.songs;

import com.example.songs.artist.Artist;
import com.example.songs.song.MusicKey;
import com.example.songs.song.Song;
import com.example.songs.song.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SongsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SongRepository songRepository) {
        return args -> {
            System.out.println("Hello from CLR");

            Artist ladyGaga = new Artist("lady_gaga");
            System.out.println(ladyGaga);
//            songRepository.saveAll(
//                    List.of(
//                            new Song(MusicKey.AM, "bad_romance", ladyGaga, 120)
//                    )
//            );
            songRepository.save(new Song(MusicKey.AM, "bad_romance", ladyGaga, 120));
        };
    }

}
