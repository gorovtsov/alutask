package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long>{

    Manager findByLogin(String login);

}
