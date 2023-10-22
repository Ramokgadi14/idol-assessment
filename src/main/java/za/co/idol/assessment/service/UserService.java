package za.co.idol.assessment.service;



import za.co.idol.assessment.entities.User;
import za.co.idol.assessment.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    User getUserById(long id) throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;
    User createUser(User user);
    User  updateUser(User user) throws UserNotFoundException;
    List<User> getUsers();
    void deleteUser(String email) throws UserNotFoundException;


}
