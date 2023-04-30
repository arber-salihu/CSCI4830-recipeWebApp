package com.example.recipewebapp.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User firstUser = new User(
                    "firstUser",
                    "firstUser@test.com",
                    "first1"
            );

            repository.saveAll(
                    List.of(firstUser)
            );
        };
    }
}
