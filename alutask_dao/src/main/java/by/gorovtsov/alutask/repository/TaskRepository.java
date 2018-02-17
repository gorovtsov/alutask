package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.enumeration.TaskStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByProjectName(String projectName);

    List<Task> findAllByDeveloperName(String developerLogin);

    @Query("update Task set status = ?2 where id = ?1")
    void setTaskStatus(long id, TaskStatus status);
}