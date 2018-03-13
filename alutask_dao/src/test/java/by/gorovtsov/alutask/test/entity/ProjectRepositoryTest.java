package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.repository.ProjectRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectRepositoryTest extends BaseTest {

    @Autowired
    ProjectRepository repository;

    @Test
    public void findTop5Test() {
        repository.findTop5ByManagerName("Alexander Manager").forEach(project -> System.out.println(project.getName()));
    }

    @Test
    public void findTop5ByManagerName() {
        List<Project> projects = repository.findTop5ByManagerNameOrderByTimerEndAsc("Alexander Manager");
        projects.forEach(project -> System.out.println(project.getTimer().getEnd()));
    }

    @Test
    public void findTop5ByManagerLogin() {
        List<Project> projects = repository.findTop5ByManagerLoginOrderByTimerEndAsc("aluman");

        projects.forEach(project -> System.out.println(project.getName()));
    }
}
