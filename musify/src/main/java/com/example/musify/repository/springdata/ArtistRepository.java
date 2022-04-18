package com.example.musify.repository.springdata;

import com.example.musify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    @Modifying
    @Query(value = "UPDATE Artist a SET a.firstName=:firstName, a.lastName=:lastName, a.stageName=:stageName, a.birthday=:birthday, a.startActivePeriod=:startActivePeriod, a.endActivePeriod=:endActivePeriod WHERE a.id = :id")
    void updateArtist(
            @Param("id") Integer id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("stageName") String stageName,
            @Param("birthday") LocalDate birthday,
            @Param("startActivePeriod") String startActivePeriod,
            @Param("endActivePeriod") String endActivePeriod
    );

    @Query(value = "SELECT COUNT(a) FROM Artist a WHERE a.firstName LIKE %:firstName%")
    int countArtist(@Param("firstName") String firstName);
}
