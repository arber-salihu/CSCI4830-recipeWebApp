package com.example.recipewebapp.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserDataService userService;

    @Autowired
    public UserController(UserDataService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userService.registerNewUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
