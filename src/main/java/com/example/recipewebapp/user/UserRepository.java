package com.example.recipewebapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    //This is a function to implement for login. But I gave up bc I was tired.
    Optional<Object> findByUsernameAndPassword(String username, String password);


}
