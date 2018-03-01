package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.project.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
