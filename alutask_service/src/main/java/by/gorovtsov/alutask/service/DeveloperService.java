package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    List<Developer> findAll(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level);

    List<Developer> findAll();
}
