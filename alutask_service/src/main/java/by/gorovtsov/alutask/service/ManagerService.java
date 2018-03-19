package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.Manager;

public interface ManagerService {
    Manager findManagetByUsername(String username);
}
