package com.example.musify.dto;


import com.example.musify.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDTO {
    private Integer id;
    private String name;
    private Type type;
    private Date createdDate;
    private Date lastUpdateDate;
}
