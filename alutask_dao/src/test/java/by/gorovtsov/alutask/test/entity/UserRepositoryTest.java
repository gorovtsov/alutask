package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends BaseTest {

    @Autowired
    UserRepository repository;

    @Test
    public void saveUserTest() {
        User user = new User("Victor Vorobyov", "zerger", "passTest", "zerger@gmail.com", Role.DEVELOPER);
        repository.save(user);
        User byLogin = repository.findByLogin(user.getLogin());
        System.out.println(byLogin);
    }
}
