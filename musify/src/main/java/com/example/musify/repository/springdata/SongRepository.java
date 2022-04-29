package com.example.musify.repository.springdata;

import com.example.musify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    @Query(value = "SELECT s FROM Song s WHERE (:title = s.title ) ")
    List<Song> filterSortSongs(
            @Param("title") String title
    );

    //JOIN SongAlternativeTitle sa
    //OR :title=sa.title
}
