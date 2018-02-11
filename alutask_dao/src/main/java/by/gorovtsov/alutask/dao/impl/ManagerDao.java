package by.gorovtsov.alutask.dao.impl;

import by.gorovtsov.alutask.dao.BaseDao;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.Manager;
import org.hibernate.Session;

public class ManagerDao extends BaseDao<Manager> {
    public void addDeveloperToProject(Developer developer, Project project) {
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();

        session.saveOrUpdate(developer);
        session.saveOrUpdate(project);

        project.addDeveloper(developer);
        session.getTransaction().commit();
        session.close();
    }
}
