package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.dto.DeveloperPageDto;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    DeveloperPageDto findFiltered(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level);

    List<Developer> findAll();
}
