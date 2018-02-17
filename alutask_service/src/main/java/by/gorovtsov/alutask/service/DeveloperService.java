package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.Developer;

import java.util.List;

public interface DeveloperService {
    List<Developer> findAll(int offset, int limit);
}
