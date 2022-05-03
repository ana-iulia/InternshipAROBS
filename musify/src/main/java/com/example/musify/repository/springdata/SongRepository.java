package com.example.musify.repository.springdata;

import com.example.musify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {


    @Query(value = "SELECT s FROM Song s LEFT JOIN SongAlternativeTitle sa ON sa.song.id=s.id WHERE (s.title LIKE CONCAT('%', :title, '%') OR sa.title LIKE CONCAT('%', :title, '%'))")
    List<Song> filterSortSongs(
            @Param("title") String title
    );

}
