package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.project.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long>, PagingAndSortingRepository<Task, Long> {

    List<Task> findByName(String name);

    List<Task> findByProjectNameOrderByTimerEnd(String projectName);

    List<Task> findTop5ByProjectNameOrderByTimerEnd(String projectName);

    Task findById(Long id);

    Page<Task> findByProjectId(Long id, Pageable pageable);

    Integer countByProjectId(Long id);

}
