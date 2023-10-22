package za.co.idol.assessment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.co.idol.assessment.entities.User;
import za.co.idol.assessment.exception.UserNotFoundException;
import za.co.idol.assessment.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {


    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

    }


    @Test
    void getUserByEmailTest() throws UserNotFoundException {

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("Joe@gmail.com");
        this.userRepository.saveAndFlush(user);

        when(this.userRepository.findByEmail("Joe@gmail.com")).thenReturn(user);

        User user1 = userService.getUserByEmail("Joe@gmail.com");

        assertNotNull(user1);
        assertEquals("Joe@gmail.com", user1.getEmail());
    }



    @Test
    void getUserByEmailNotFound() {

       try{
            userService.getUserByEmail("Kpe@g.com");
            fail("Expected SomeException, but no exception was thrown.");
       }
       catch ( UserNotFoundException e)
       {
         assertEquals("Investor with email: Kpe@g.com  not found", e.getMessage());
       }
    }
}