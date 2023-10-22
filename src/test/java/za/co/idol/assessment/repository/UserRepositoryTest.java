package za.co.idol.assessment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.co.idol.assessment.entities.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

        @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findById() {

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("Joe@gmail.com");

        when(this.userRepository.findById(1L)).thenReturn(user);

        User user1 = this.userRepository.findById(1L);

        assertNotNull(user1);
        assertEquals(1, user1.getId());

    }

    @Test
    void findByEmail() {

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setEmail("Joe@gmail.com");

        when(this.userRepository.findByEmail("Joe@gmail.com")).thenReturn(user);

        User user1 = this.userRepository.findByEmail("Joe@gmail.com");

        assertNotNull(user1);
        assertEquals("Joe@gmail.com", user1.getEmail());
    }

}