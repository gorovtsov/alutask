package by.gorovtsov.alutask;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOTest {

    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    public User getUserTest() {
        Session session = SESSION_FACTORY.openSession();

        return session
                .createQuery("select d from Developer d where name = :name", Developer.class)
                .setParameter("name", "Alexander Gorovtsov").getSingleResult();
    }
}