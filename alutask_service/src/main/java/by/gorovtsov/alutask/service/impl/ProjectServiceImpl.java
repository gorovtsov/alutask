package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.repository.ProjectRepository;
import by.gorovtsov.alutask.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<String> findProjectNamesForCurrentManager() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        List<String> projectNames = new ArrayList<>();
        repository.findByManagerLogin(login).forEach(project -> projectNames.add(project.getName()));

        return projectNames;
    }

    @Override
    public Project findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Project> findProjectsByManagerUsername(String username) {
        return repository.findByManagerLogin(username);
    }
}
