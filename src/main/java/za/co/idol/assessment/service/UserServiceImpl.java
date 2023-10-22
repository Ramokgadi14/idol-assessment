package za.co.idol.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.idol.assessment.entities.User;
import za.co.idol.assessment.exception.UserNotFoundException;
import za.co.idol.assessment.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("Investor with Id: " + id + "  not found");
        } else {
            return user;
        }


    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("Investor with email: " + email + "  not found");
        } else {
            return user;
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User updateUser(User user) throws UserNotFoundException {
         User userToUpdate = getUserById(user.getId());

         userToUpdate.setName(user.getName());
         userToUpdate.setSurname(user.getSurname());
         userToUpdate.setAddress(user.getAddress());
         userToUpdate.setPhoneNumber(user.getPhoneNumber());
         userToUpdate.setDateOfBirth(user.getDateOfBirth());

        return createUser(userToUpdate);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String email) throws UserNotFoundException {
       User user = getUserByEmail(email);
        userRepository.delete(user);
    }

    public void setUserRepository(UserRepository user) {
        this.userRepository = user;
    }

}
