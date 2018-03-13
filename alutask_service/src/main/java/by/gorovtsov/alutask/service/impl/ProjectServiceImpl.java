package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.repository.ProjectRepository;
import by.gorovtsov.alutask.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> findEnding5ByManagerLogin(String managerLogin) {
        return repository.findTop5ByManagerLoginOrderByTimerEndAsc(managerLogin);
    }
}
