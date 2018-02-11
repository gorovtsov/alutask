package by.gorovtsov.alutask.dao.impl;

import by.gorovtsov.alutask.dao.BaseDao;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.TaskStatus;
import org.hibernate.Session;

import java.util.List;

public class TaskDao extends BaseDao<Task> {

    public void openTask(Task task) {
        Session session = SESSION_FACTORY.openSession();
        session.save(task);
        session.close();
    }

    public List<Task> findTasksOfProject(Project project) {
        Session session = SESSION_FACTORY.openSession();

        List<Task> result = session.createQuery("select t from Task t where t.project.id = :projectId", Task.class)
                .setParameter("projectId", project.getId())
                .getResultList();

        session.close();

        return result;
    }

    public void changeTaskStatus(Task task, TaskStatus status) {
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();

        session.persist(task);
        task.setStatus(status);

        session.getTransaction().commit();
        session.close();
    }

    public List<Task> findTasksByDeveloper(Developer developer) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        session.persist(developer);
        List<Task> result = session.createQuery("select t from Task t where t.developer.id = :devId", Task.class)
                .setParameter("devId", developer.getId())
                .getResultList();
        return result;
    }
}
