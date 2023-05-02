package com.example.recipewebapp.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserDataService userDataService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testUser", "test@example.com", "password");
        user.setUser_id(1L);
    }

    @Test
    void getUserById() {
        when(userDataService.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);

        assertNotNull(result);
        assertEquals(user, result);
        verify(userDataService, times(1)).getUserById(1L);
    }

    @Test
    void getUserByUsername() {
        when(userDataService.getUserByUsername("testUser")).thenReturn(user);

        User result = userController.getUserByUsername("testUser");

        assertNotNull(result);
        assertEquals(user, result);
        verify(userDataService, times(1)).getUserByUsername("testUser");
    }

    @Test
    void addUser() {
        doNothing().when(userDataService).registerNewUser(user);

        ResponseEntity<Void> result = userController.addUser(user);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(userDataService, times(1)).registerNewUser(user);
    }

    @Test
    void updateUser() {
        User updatedUser = new User("updatedUser", "updated@example.com", "newPassword");
        updatedUser.setUser_id(1L);
        when(userDataService.updateUser("testUser", updatedUser)).thenReturn(updatedUser);

        ResponseEntity<User> result = userController.updateUser("testUser", updatedUser);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updatedUser, result.getBody());
        verify(userDataService, times(1)).updateUser("testUser", updatedUser);
    }

    @Test
    void deleteUser() {
        doNothing().when(userDataService).deleteUser(1L);

        ResponseEntity<Void> result = userController.deleteUser(1L);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(userDataService, times(1)).deleteUser(1L);
    }
}

