package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.project.Project;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByManagerName(String managerName);

    List<Project> findTop5ByManagerName(String managerName);

    List<Project> findByTimerStartOrderByTimerStartAsc(LocalDateTime localDateTime);

    List<Project> findTop5ByManagerNameOrderByTimerEndAsc(String managerName);

    List<Project> findTop5ByManagerLoginOrderByTimerEndAsc(String managerLogin);


    Project findByName(String name);
}
