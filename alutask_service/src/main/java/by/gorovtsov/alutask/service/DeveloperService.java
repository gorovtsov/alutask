package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;

import java.util.List;

public interface DeveloperService {
    List<Developer> findAll(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level);
}
