package za.co.idol.assessment.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.idol.assessment.entities.User;
import za.co.idol.assessment.exception.UserNotFoundException;
import za.co.idol.assessment.service.UserService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @InjectMocks
    private UserController userController;


    @Mock
    private UserService userService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void requestRetirementWithdrawal() throws UserNotFoundException {

        String mail = "joe@gmail.com";
        when(userService.getUserByEmail(mail)).thenReturn(null);

        ResponseEntity<User> responseEntity = userController.getUserByMail(mail);

        verify(userService, times(1)).getUserByEmail(mail);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //Map<String, String> responseBody = responseEntity.getBody();
        //assertEquals("Withdrawal request sent successfully", responseBody.get("Message"));
    }


    @Test
    public void testGetUserByMail_Success() throws UserNotFoundException {
        User user = createUser();

        when(userService.getUserByEmail(user.getEmail())).thenReturn(user);

        ResponseEntity<User> responseEntity = userController.getUserByMail(user.getEmail());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void testGetUsers(){
        User user = createUser();
        when(userService.getUsers()).thenReturn(Collections.singletonList(user));

        ResponseEntity<List<User>> responseEntity = userController.getUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user,Collections.singletonList(user).get(0));
    }

    private User createUser()
    {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("Joe@gmail.com");
        user.setAddress("Midrand");
        user.setPhoneNumber("0813004779");
        return  user;
    }

}