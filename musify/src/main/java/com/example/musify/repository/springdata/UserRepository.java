package com.example.musify.repository.springdata;

import com.example.musify.model.Status;
import com.example.musify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

//    @Modifying
//    @Query(value = "UPDATE User u SET u.status=:status WHERE u.id = :id")
//    void updateUser(
//            @Param("id") Integer id,
//            @Param("status") Status status
//    );
}
