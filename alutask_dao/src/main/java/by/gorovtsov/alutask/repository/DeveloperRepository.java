package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {

    Developer findByName(String name);

    List<Developer> findByLanguageAndLevel(String language, String level, Pageable pageable);

    int countByLanguageAndLevel(ProgrammingLanguage language, DeveloperLevel level);
}
