package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {

    Developer findByLogin(String login);

}
