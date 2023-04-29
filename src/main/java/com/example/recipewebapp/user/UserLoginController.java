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
    public ResponseEntity<Boolean> authenticateUser(@PathVariable("username") String username,@PathVariable("password") String password) {
        boolean isAuthenticated = userService.authenticateUser(username, password);
        if (isAuthenticated) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
    }
}
