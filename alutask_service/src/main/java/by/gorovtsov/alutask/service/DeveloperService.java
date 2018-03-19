package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;

import java.util.List;


public interface DeveloperService {
    List<Developer> findAll();

    List<Developer> findPageByLanguageAndLevel(ProgrammingLanguage language, DeveloperLevel level, int pageNum, int pageSize);

    List<Long> getPageNums(ProgrammingLanguage language, DeveloperLevel level, int pageSize);

    Developer findByLogin(String username);
}
