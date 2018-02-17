package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
}
