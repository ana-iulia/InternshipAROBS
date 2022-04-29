//package com.example.musify.service;
//
//import com.example.musify.dto.LoginRequestDTO;
//import com.example.musify.mapper.UserMapper;
//import com.example.musify.model.Role;
//import com.example.musify.model.Status;
//import com.example.musify.model.User;
//import com.example.musify.repository.springdata.UserRepository;
//import com.example.musify.security.JwtUtils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//class UserServiceTest {
//
//    @Spy
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService service;
//
//    @Mock
//    private UserMapper userMapper;
//
//    @Mock
//    private JwtUtils jwtUtils;
//
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void givenValidRegisterRequestDTO_whenLogin_thenResultIsValid() {
//        User u = new User(1, "TestFirstName", "TestLastName", "test@email.com", "password", "Romania", Role.REGULAR, Status.ACTIVE, null, null);
//        LoginRequestDTO loginRequestDTO = new LoginRequestDTO("test@email.com", "password");
//        when(userRepository.findByEmail("test@email.com")).thenReturn(u);
//        when(userMapper.loginToUser(loginRequestDTO)).thenReturn(u);
//        when(passwordEncoder.matches("password", "password")).thenReturn(true);
//
//        String s = service.login(loginRequestDTO);
//        assertEquals(s, jwtUtils.generateToken(u.getId(), u.getEmail(), u.getRole(), "valid"));
//        verify(userRepository, Mockito.times(1))
//                .findByEmail(Mockito.anyString());
//
//    }
//
//    @Test
//    public void givenNonValidRegisterRequestDTO_whenLogin_thenResultIsError() {
//        User u = new User(1, "TestFirstName", "TestLastName", "test@email.com", "password", "Romania", Role.REGULAR, Status.ACTIVE, null, null);
//        LoginRequestDTO loginRequestDTO = new LoginRequestDTO("test@email.com", "pass");
//        when(userRepository.findByEmail(u.getEmail())).thenReturn(u);
//        when(userMapper.loginToUser(loginRequestDTO)).thenReturn(u);
//        when(passwordEncoder.matches(u.getPassword(), u.getPassword())).thenReturn(true);
//
//        Exception exception = assertThrows(Exception.class, () -> service.login(loginRequestDTO));
//        assertEquals("Bad credentials", exception.getMessage());
//        User u2 = new User(2, "", "", "", "", "", Role.REGULAR, Status.ACTIVE, null, null);
//        LoginRequestDTO loginRequestDTO2 = new LoginRequestDTO("test@email", "password");
//        when(userMapper.loginToUser(loginRequestDTO2)).thenReturn(u2);
//        exception = assertThrows(Exception.class, () -> service.login(loginRequestDTO2));
//        assertEquals("Bad credentials", exception.getMessage());
//
//        verify(userRepository, Mockito.times(2))
//                .findByEmail(Mockito.anyString());
//
//    }
//
//
//}