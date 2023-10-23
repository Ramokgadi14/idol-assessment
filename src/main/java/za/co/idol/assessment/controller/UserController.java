package za.co.idol.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.co.idol.assessment.entities.User;
import za.co.idol.assessment.exception.UserNotFoundException;
import za.co.idol.assessment.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{email})")
    public ResponseEntity<User> getUserByMail(@PathVariable("email") String email) throws UserNotFoundException {

        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(){

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PutMapping("/create")
    public  ResponseEntity<User> createUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<User> updateUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }

    @GetMapping("/delete/{email})")
    public ResponseEntity deleteByMail(@PathVariable("email") String email) throws UserNotFoundException {
        userService.deleteUser(email);
        return  new ResponseEntity("User deleted successfully",HttpStatus.OK);
    }

}
