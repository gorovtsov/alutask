package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;

@Component
public interface DeveloperRepository extends CrudRepository<Developer, Long>, QueryDslPredicateExecutor<Developer> {

    Developer findByName(String name);

    List<Developer> findByLanguageAndLevel(ProgrammingLanguage language, DeveloperLevel level, Pageable pageable);

    //List<Developer> findAll(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level);
}
