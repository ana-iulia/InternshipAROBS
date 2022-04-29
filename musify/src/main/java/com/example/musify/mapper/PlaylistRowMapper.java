package com.example.musify.mapper;
import com.example.musify.model.*;
import com.example.musify.repository.springdata.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistRowMapper implements RowMapper<Playlist> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Playlist mapRow(ResultSet rs, int rowNum) throws SQLException {
        Playlist playlist = new Playlist();
        playlist.setId(rs.getInt("id"));
        playlist.setName(rs.getString("name"));
        String type = rs.getString("type");
        if (type.equals(Type.PRIVATE.toString())) {
            playlist.setType(Type.PRIVATE);
        } else playlist.setType(Type.PUBLIC);
        playlist.setCreatedDate(rs.getDate("createdDate"));
        playlist.setLastUpdateDate(rs.getDate("lastUpdateDate"));
        User user = userRepository.getById(rs.getInt("user_id"));
        playlist.setUser(user);

        return playlist;
    }
}
