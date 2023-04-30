package com.example.recipewebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalStateException("No user with username" + username));
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

    public void updateUser(String username, User updatedUser) {
        User userToUpdate = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("No user with username" + username));

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

    public User authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.orElse(null);
    }


}
