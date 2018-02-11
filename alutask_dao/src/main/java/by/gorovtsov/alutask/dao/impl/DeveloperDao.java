package by.gorovtsov.alutask.dao.impl;

import by.gorovtsov.alutask.dao.BaseDao;
import by.gorovtsov.alutask.entity.user.Developer;
import org.hibernate.Session;

import java.util.List;

public class DeveloperDao extends BaseDao<Developer> {
    public List<Developer> findDeveloperByName(String name) {
        Session session = SESSION_FACTORY.openSession();
        List<Developer> result = session.createQuery("select d from Developer d where d.name = :devName", Developer.class)
                .setParameter("devName", name)
                .getResultList();
        session.close();
        return result;
    }
}
