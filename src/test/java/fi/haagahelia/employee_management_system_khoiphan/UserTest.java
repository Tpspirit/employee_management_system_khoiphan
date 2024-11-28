package fi.haagahelia.employee_management_system_khoiphan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.employee_management_system_khoiphan.domain.User;
import fi.haagahelia.employee_management_system_khoiphan.domain.UserRepository;

@DataJpaTest
public class UserTest {

     @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest() throws Exception{

        User user1 = new User("user1","password","user@email.com", "USER");
        userRepository.save(user1);

        assertThat(user1.getId()).isNotNull();
    }

    @Test
    public void deleteUserTest() throws Exception{
        User user1 = new User("user1","password","user@email.com", "USER");
        userRepository.save(user1);

        assertThat(user1.getId()).isNotNull();

        Long id = user1.getId();
        userRepository.deleteById(id);

        List<User> users = (List<User>) userRepository.findAll();

        assertThat(users).hasSize(2);
    }

    @Test
    public void searchUserTest() throws Exception{

        User user1 = new User("user1","password","user@email.com", "USER");
        userRepository.save(user1);

        assertThat(user1.getId()).isNotNull();

        User user = userRepository.findByUsername("user1");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("user1");
    }
}
