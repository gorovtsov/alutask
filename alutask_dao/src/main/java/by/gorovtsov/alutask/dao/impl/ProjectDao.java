package by.gorovtsov.alutask.dao.impl;

import by.gorovtsov.alutask.dao.BaseDao;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.user.Manager;
import org.hibernate.Session;

import java.util.List;

public class ProjectDao extends BaseDao<Project> {
    public void openProject(Project projectToOpen) {
        super.saveOrUpdate(projectToOpen);
    }

    public List<Project> findProjectByManager(Manager manager) {
        Session session = SESSION_FACTORY.openSession();

        List<Project> result =  session.createQuery("select p from Project p where p.manager = :managerName", Project.class)
                .setParameter("managerName", manager.getName())
                .getResultList();
        return result;
    }
}
