package com.example.recipewebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/login")
@CrossOrigin(origins = "http://localhost:3000")

public class UserLoginController {


    private final UserDataService userService;

    @Autowired
    public UserLoginController(UserDataService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User authenticatedUser = userService.authenticateUser(username, password);
        if (authenticatedUser != null) {
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
