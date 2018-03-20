package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.entity.project.Task;

import javax.persistence.OptimisticLockException;
import java.util.List;

public interface TaskService{

    List<Task> getTaskPageByProjectId(Long projectId, int pageNum, int offset);

    List<Integer> getPageNumbersByProjectId(Long projectId);

    Task getTaskById(Long id);

    void saveTask(Task task) throws OptimisticLockException;

    List<Task> getHot5TasksByProjectName(String projectName);
}
