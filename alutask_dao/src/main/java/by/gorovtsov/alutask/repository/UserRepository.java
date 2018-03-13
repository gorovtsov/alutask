package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);

    @Override
    User save(User user);
}
