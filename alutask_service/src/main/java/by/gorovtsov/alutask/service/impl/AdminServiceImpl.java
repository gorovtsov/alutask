package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.dto.DeveloperDTO;
import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.repository.ManagerRepository;
import by.gorovtsov.alutask.repository.UserRepository;
import by.gorovtsov.alutask.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private UserRepository userRepository;
    private DeveloperRepository developerRepository;
    private ManagerRepository managerRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository,
            DeveloperRepository developerRepository,
            ManagerRepository managerRepository) {
        this.userRepository = userRepository;
        this.developerRepository = developerRepository;
        this.managerRepository = managerRepository;
    }

    @Override
    public boolean changeUserRole(Long userId, String role) {
        userRepository.changeUserRole(userId, Role.valueOf(role.toUpperCase()));
        return false;
    }

    @Override
    public void addDeveloper(User user, DeveloperDTO developerDTO) {

    }
}
