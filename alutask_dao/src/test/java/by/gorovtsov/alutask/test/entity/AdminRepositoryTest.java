package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRepositoryTest extends BaseTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void changeUserRoleTest() {
        userRepository.changeUserRole(237L, Role.DEVELOPER);
        User user = userRepository.findOne(237L);
        System.out.println(user);
    }
}
