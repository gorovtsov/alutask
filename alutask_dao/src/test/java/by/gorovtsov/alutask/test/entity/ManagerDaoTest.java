package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.dao.impl.ManagerDao;
import by.gorovtsov.alutask.dao.impl.ProjectDao;
import by.gorovtsov.alutask.entity.embedded.Timer;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.Manager;
import by.gorovtsov.alutask.enumeration.Department;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ManagerDaoTest {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate-test.cfg.xml").buildSessionFactory();

    @Test
    public void addDeveloperToProjectTest(){
        Session session = SESSION_FACTORY.openSession();
        ProjectDao projectDao = new ProjectDao();
        ManagerDao managerDao = new ManagerDao();
        DeveloperDao developerDao = new DeveloperDao();

        Timer timer = new Timer(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        Manager manager = new Manager("Bro Forcing", "sert", "senji@rambler.ru", "runner3",
                Department.FRONTEND);
        Developer developer = new Developer("Zheka Vino", "zhen9", "zheka@gmail.com", "pass123",
                ProgrammingLanguage.C, DeveloperLevel.SENIOR);
        Project project = new Project(manager, "ProjectDaoTestCool!", "It's amazing description!", timer);

        Session savingSession = SESSION_FACTORY.openSession();
        managerDao.saveOrUpdate(manager, savingSession);
        developerDao.saveOrUpdate(developer, savingSession);
        projectDao.openProject(project, savingSession);
        managerDao.addDeveloperToProject(developer, project, savingSession);
        savingSession.close();

        Developer testDeveloper = session.createQuery("select d from Developer d where name = :devName", Developer.class)
                .setParameter("devName", "Zheka Vino")
                .getSingleResult();

        System.out.println(testDeveloper);
        Project foundProject = session.createQuery("select p from Project p join p.developers d where d.name = :devName", Project.class)
                .setParameter("devName", "Zheka Vino").getSingleResult();

        session.close();

        assertThat(foundProject.getName(), is(project.getName()));
    }
}
