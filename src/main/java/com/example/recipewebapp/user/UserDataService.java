package com.example.recipewebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDataService {

    private final UserRepository userRepository;

    @Autowired
    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));
    }

    public void registerNewUser(User user) {
        boolean emailExists = userRepository.existsByEmail(user.getEmail());
        boolean usernameExist = userRepository.existsByUsername(user.getUsername());
        if (emailExists) {
            throw new IllegalStateException("Email is already taken");
        }
        if (usernameExist) {
            throw new IllegalStateException("Username is already taken");
        }
        userRepository.save(user);
    }

    public void updateUser(Long userId, User updatedUser) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));

        // check if email is being changed to an already existing email
        if (!userToUpdate.getEmail().equals(updatedUser.getEmail())) {
            boolean emailExists = userRepository.existsByEmail(updatedUser.getEmail());
            boolean usernameExists = userRepository.existsByUsername(updatedUser.getUsername());
            if (emailExists) {
                throw new IllegalStateException("Email is already taken");
            }
            if (usernameExists){
                throw new IllegalStateException("Username is already taken");
            }
        }

        userToUpdate.setUsername(updatedUser.getUsername());
        userToUpdate.setEmail(updatedUser.getEmail());
        userRepository.save(userToUpdate);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    //This is a function to implement for login. But I gave up bc I was tired.
    public User getUserByUsernameAndPassword(String username, String password) {
        return (User) userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new IllegalStateException("invalid username or password"));
    }
}
