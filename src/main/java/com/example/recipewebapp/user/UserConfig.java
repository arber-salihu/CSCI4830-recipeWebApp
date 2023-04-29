//package com.example.recipewebapp.user;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository) {
//        return args -> {
//            User firstUser = new User(
//                    "firstUser",
//                    "firstUser@test.com",
//                    "f!rst"
//            );
//
//            repository.saveAll(
//                    List.of(firstUser)
//            );
//        };
//    }
//}
