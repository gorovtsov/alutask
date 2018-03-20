package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.annotation.Loggable;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long>, PagingAndSortingRepository<Developer, Long> {

    @Loggable
    Developer findByLogin(String login);

    List<Developer> findAll();

    Page<Developer> findByLanguageAndLevel(ProgrammingLanguage language, DeveloperLevel level, Pageable pageable);

    Long countByLanguageAndLevel(ProgrammingLanguage language, DeveloperLevel level);

    List<Developer> findByProjectsContains(Project project);
}
