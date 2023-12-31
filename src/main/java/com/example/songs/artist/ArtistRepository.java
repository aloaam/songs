package com.example.songs.artist;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findArtistByName(String artistName);

    @Modifying
    @Transactional
    @Query("update Artist a SET a.name = :name WHERE a.id = :id")
    void updateArtist(@Param("id") Long id, @Param("name") String name);
}
