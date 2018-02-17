package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.Developer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {

    Developer findByName(String name);

    @Query()
    List<Developer> findAll(Pageable pageable);
}
