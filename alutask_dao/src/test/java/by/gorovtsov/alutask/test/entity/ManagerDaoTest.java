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
import org.junit.Test;

import java.time.LocalDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ManagerDaoTest extends BaseDaoTest{
    @Test
    public void addDeveloperToProjectTest(){
        Session session = SESSION_FACTORY.openSession();
        ProjectDao projectDao = new ProjectDao();
        ManagerDao managerDao = new ManagerDao();
        DeveloperDao developerDao = new DeveloperDao();

        Timer timer = new Timer(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        Manager manager = new Manager("Carles Puyol", "tryharder", "puy@rambler.ru", "runner3",
                Department.FRONTEND);
        Developer developer = new Developer("Bodya Kisly", "dronn", "dyr9@gmail.com", "pass123",
                ProgrammingLanguage.C, DeveloperLevel.SENIOR);
        Project project = new Project(manager, "ProjectDaoTest!", "It's amazing description!", timer);

        managerDao.saveOrUpdate(manager);
        developerDao.saveOrUpdate(developer);
        projectDao.openProject(project);
        managerDao.addDeveloperToProject(developer, project);

        Project foundProject = session.createQuery("select p from Project p join p.developers d where d.name = :devName", Project.class).setParameter("devName", "Bodya Kisly").getSingleResult();

        session.close();

        assertThat(foundProject.getName(), is(project.getName()));
    }
}
