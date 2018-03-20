package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.dto.DeveloperDTO;
import by.gorovtsov.alutask.entity.user.User;

public interface AdminService {
    boolean changeUserRole(Long userId, String role);

    void addDeveloper(User user, DeveloperDTO developerDTO);
}
