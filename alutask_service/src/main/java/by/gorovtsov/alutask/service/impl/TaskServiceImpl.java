package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.repository.ProjectRepository;
import by.gorovtsov.alutask.repository.TaskRepository;
import by.gorovtsov.alutask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final int defaultPageSize = 5;

    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void saveTask(Task task) throws OptimisticLockException {
        Task checkingTask = taskRepository.findById(task.getId());

        if (task.getVersion() < checkingTask.getVersion()) {
            throw new OptimisticLockException("Someone already changed this task. Please, try one more time");
        }
        task.setProject(projectRepository.findByName(task.getProject().getName()));
        taskRepository.save(task);
    }

    @Override
    public List<Task> getHot5TasksByProjectName(String projectName) {
        return taskRepository.findTop5ByProjectNameOrderByTimerEnd(projectName);
    }

    @Override
    public List<Integer> getPageNumbersByProjectId(Long projectId) {
        int taskCount = taskRepository.countByProjectId(projectId);
        int pagesCount = taskCount / defaultPageSize + 1;

        List<Integer> pageNumbers = new ArrayList<>();

        for (int i = 1; i <= pagesCount; i++) {
            pageNumbers.add(i);
        }

        return pageNumbers;
    }

    @Override
    public List<Task> getTaskPageByProjectId(Long projectId, int pageNum, int offset) {
        List<Task> result = new LinkedList<>();
        Page<Task> page = taskRepository.findByProjectId(projectId, new PageRequest(pageNum, offset));

        page.forEach(result::add);
        return result;
    }
}
