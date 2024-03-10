package com.polysoft.platfrom.unit;

import com.polysoft.platfrom.entity.Users;
import com.polysoft.platfrom.repository.ArticlesTagsRepository;
import com.polysoft.platfrom.repository.InterestsRepository;
import com.polysoft.platfrom.repository.UsersRepository;
import com.polysoft.platfrom.service.impli.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@SpringBootTest
public class UsersTest {

    @Mock
    private UsersRepository userRepository;
    @Mock
    private InterestsRepository interestsRepository;
    @Mock
    private ArticlesTagsRepository articlesTagsRepository;

    private UsersService usersService;

    @Autowired
    public UsersTest(UsersService usersService) {
        this.usersService = usersService;
    }

    @BeforeEach
    public void setUp() {
        // Configure additional mock behavior as needed
    }

    @Test
    public void registerUser_withValidUser_shouldSaveUser() {
        // Create a test user
        Users user = new Users();
        user.setUserName("testUser");
        user.setPassword("password");

        // Mock behavior
        Mockito.when(userRepository.save(user)).thenReturn(user);

        // Call registerUser
        Users savedUser = usersService.registerUser(user);

        // Assertions
        assertNotNull(savedUser);
        assertEquals(user.getUserName(), savedUser.getUserName());
        Mockito.verify(userRepository, times(1)).save(user);
    }

    // ... additional tests for other methods
}
