package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationTest extends BaseControllerTest{
    @Autowired
    RegistrationController controller;

    @Test
    public void registerNewUserTest() {
        controller.registerUser(new User("Andriy", "volw45", "andre@rambler.ru", "parol123", Role.GUEST));
    }
}
