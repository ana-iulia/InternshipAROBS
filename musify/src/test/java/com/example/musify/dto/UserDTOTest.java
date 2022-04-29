package com.example.musify.dto;

import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDTOTest {

    @Test
    public void givenValidUserDTO_whenSerializingAndDeserializing_thenResultIsSimilar() throws JsonProcessingException {
        UserDTO userDTO = new UserDTO("TestFirstName", "TestLAstName", "test@email.com", "Romania", Role.REGULAR, Status.ACTIVE);
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(userDTO);
        UserDTO readValue = objectMapper.readValue(writeValueAsString, UserDTO.class);
        assertEquals(userDTO, readValue);

    }

}