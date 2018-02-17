package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.project.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Project findByManagerName(String name);
}
