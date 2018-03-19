package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.project.Project;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {
    List<Project> findEnding5ByManagerLogin(String managerLogin);

    List<String> findProjectNamesForCurrentManager();

    List<Project> findProjectsByManagerUsername(String username);

    Project findById(Long id);
}
