package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.project.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<Project> findEnding5ByManagerLogin(String managerLogin);
}
