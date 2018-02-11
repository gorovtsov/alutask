package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.dao.impl.ProjectDao;
import by.gorovtsov.alutask.entity.embedded.Timer;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.user.Manager;
import by.gorovtsov.alutask.enumeration.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProjectDaoTest {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate-test.cfg.xml").buildSessionFactory();

    @Test
    public void openProjectTest(){
        Timer timer = new Timer(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        ProjectDao projectDao = new ProjectDao();

        Project foundProject;

        Session session = SESSION_FACTORY.openSession();
        session.save(new Manager("Carles Puyol", "tryharder", "puy@rambler.ru", "runner3",
                Department.FRONTEND));
        Manager manager = session.createQuery("select m from Manager m where m.login = :managerLogin", Manager.class)
                .setParameter("managerLogin", "tryharder").getSingleResult();
        projectDao.openProject(new Project(manager, "Great project!", "It's amazing description!", timer), session);

        foundProject = session.createQuery("select p from Project p where p.name = :projName", Project.class)
                .setParameter("projName", "Great project!")
                .getSingleResult();

        session.close();

        System.out.println(foundProject.getName());

        assertThat(foundProject.getName(), is("Great project!"));
    }
}
