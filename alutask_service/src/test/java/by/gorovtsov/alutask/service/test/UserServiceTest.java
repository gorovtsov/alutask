package by.gorovtsov.alutask.service.test;

import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void loadUserByUserNameTest() {
        UserDetails user = userService.loadUserByUsername("jackass");

        System.out.println(user);
    }

    @Test
    public void encodingTest() {
        userService.registerNewUser(new User("Andriy", "volw45", "andre@rambler.ru", "parol123", Role.GUEST));
    }
}
