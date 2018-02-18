package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Developer;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DeveloperRepository extends CrudRepository<Developer, Long>, QueryDslPredicateExecutor<Developer> {

    Developer findByName(String name);

    //List<Developer> findAll(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level);
}
