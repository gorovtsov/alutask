package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User registerNewUser(User user);

    List<User> findAllGuests();

    User findUserById(Long userId);
}
