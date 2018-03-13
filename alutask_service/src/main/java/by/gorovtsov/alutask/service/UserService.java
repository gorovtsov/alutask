package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerNewUser(User user);
}
