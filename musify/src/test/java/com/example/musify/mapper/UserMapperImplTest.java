package com.example.musify.mapper;

import com.example.musify.dto.LoginRequestDTO;
import com.example.musify.dto.UserDTO;
import com.example.musify.model.Role;
import com.example.musify.model.Status;
import com.example.musify.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserMapperImplTest {

    @BeforeAll
    private static void setUp() {
        System.out.println("SetUp was executed.");
    }

    @BeforeEach
    public void init() {
        System.out.println("Init was executed");
    }

    @Test
    @DisplayName("Test UserDTO valid")
    public void givenValidUser_whenMappingToUserDTO_thenReturnValidDTO() {
        User user = new User(1, "TestFirstName", "TestLAstName", "test@email.com", "password", "Romania", Role.REGULAR, Status.ACTIVE, null, null);
        UserMapper userMapper = new UserMapperImpl();
        UserDTO userDTO = userMapper.toUserDTO(user);
        Assertions.assertEquals(userDTO.getFirstName(), user.getFirstName());

    }

    @Test
    @DisplayName("Test UserDTO null")
    public void givenNullUser_whenMappingToUserDTO_thenReturnNull() {
        UserMapper userMapper = new UserMapperImpl();
        UserDTO userDTO = userMapper.toUserDTO(null);

        Assertions.assertNull(userDTO);

    }

    @Test
    @DisplayName("Test LoginToUser valid")
    public void givenLoginUser_whenMappingToUser_thenReturnValidUser() {
        UserMapper userMapper = new UserMapperImpl();
        LoginRequestDTO loginRequestDTO=new LoginRequestDTO("test@email.com", "password");
        User u = userMapper.loginToUser(loginRequestDTO);
        Assertions.assertEquals(u.getEmail(), loginRequestDTO.getEmail());
        Assertions.assertEquals(u.getPassword(), loginRequestDTO.getPassword());

    }

}