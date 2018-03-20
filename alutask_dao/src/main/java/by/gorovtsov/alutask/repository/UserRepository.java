package by.gorovtsov.alutask.repository;

import by.gorovtsov.alutask.entity.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);

    @Override
    User save(User user);

    @Modifying
    @Query("update User u set u.role = :role where u.id = :id")
    void changeUserRole(@Param("userId") Long userId, @Param("role") String role);
}
