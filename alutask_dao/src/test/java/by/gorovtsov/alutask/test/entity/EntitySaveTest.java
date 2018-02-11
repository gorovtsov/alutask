package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.Filter;
import by.gorovtsov.alutask.entity.embedded.Timer;
import by.gorovtsov.alutask.entity.message.Comment;
import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.project.Task;
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
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EntitySaveTest {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void saveDeveloperTest(){
        Developer developer = new Developer("Ksenia Gorovtsova", "syusya", "sususya@gmail.com", "pass123",
                ProgrammingLanguage.JAVA, DeveloperLevel.ALEXANDERGOROVTSOV);
        Developer foundDeveloper;

        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();

        session.persist(developer);
        session.save(developer);
        session.getTransaction().commit();

        foundDeveloper = session.createQuery("select d from  Developer d where d.login = :login", Developer.class)
                .setParameter("login", developer.getLogin()).getSingleResult();

        assertThat(foundDeveloper.getLevel(), is(DeveloperLevel.ALEXANDERGOROVTSOV));
    }

    @Test
    public void saveManagerTest(){
        Manager manager = new Manager("Victor Drobov", "drob", "drob@rambler.ru", "podkat1",
                Department.WEB);
        Manager foundManager;

        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();

        session.persist(manager);
        session.save(manager);
        session.getTransaction().commit();


        foundManager = session.createQuery("select m from Manager m where m.name = :managerName", Manager.class)
                .setParameter("managerName", manager.getName()).setMaxResults(1).getSingleResult();

        assertThat(foundManager.getDepartment(), is(Department.WEB));
    }

    @Test
    public void saveProjectTest(){

        Timer timer = new Timer(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));

        Project foundProject;

        Session session = SESSION_FACTORY.openSession();

        //session.save(new Manager("Johny Knoxvillelol", "jackss", "johnyhard@rambler.ru", "runner3",
          //      Department.FRONTEND));

        Manager manager = session.createQuery("select m from Manager m where m.login = :managerLogin", Manager.class)
                .setParameter("managerLogin", "jackss").getSingleResult();

        //session.save(new Project(manager, "Knoxville project", "It's amazing description!", timer));

        foundProject = session.createQuery("select p from Project p where p.manager.name = :managerName", Project.class)
                .setParameter("managerName", "Johny Knoxville").getSingleResult();
        assertThat(foundProject.getName(), is("Knoxville project"));
    }

    @Test
    public void saveTaskTest(){

        Task foundTask;

        Timer timer = new Timer(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));

        Session session = SESSION_FACTORY.openSession();

        session.save(new Developer("Bogdan Malakhovich", "bagazh", "stind@gmail.com", "psozh23",
                ProgrammingLanguage.RUBY, DeveloperLevel.GOD));

        session.save(new Manager("Vasco da Gama", "vasco", "vasya@rambler.ru", "vase432",
                Department.SALES));

        Manager manager = session.createQuery("select m from Manager m where m.login = :managerLogin", Manager.class)
                .setParameter("managerLogin", "vasco").getSingleResult();

        Developer developer = session.createQuery("select d from Developer d where d.login = :developerLogin", Developer.class)
                .setParameter("developerLogin", "bagazh").getSingleResult();

        session.save(new Project(manager, "Testing task", "Test project for task", timer));

        Project project = session.createQuery("select p from Project p where p.description = :description", Project.class)
                .setParameter("description", "Test project for task").getSingleResult();

        session.save(new Task(project, "First task", "Implement DAO tests", developer, timer));

        foundTask = session.createQuery("select t from Task t where t.name = :name", Task.class)
                .setParameter("name", "First task").getSingleResult();

        assertThat(foundTask.getDescription(), is("Implement DAO tests"));
    }

    @Test
    public void saveCommentTest(){
        Comment foundComment;

        Timer timer = new Timer(LocalDateTime.now(), LocalDateTime.now().plusMonths(1));

        Session session = SESSION_FACTORY.openSession();

        session.save(new Developer("Dmitriy bragin", "alala", "brag@gmail.com", "psozh23",
                ProgrammingLanguage.JAVA, DeveloperLevel.GOD));

        session.save(new Manager("Vincenzo", "vine", "vine@rambler.ru", "vase432",
                Department.SALES));

        Manager manager = session.createQuery("select m from Manager m where m.login = :managerLogin", Manager.class)
                .setParameter("managerLogin", "vine").getSingleResult();

        Developer developer = session.createQuery("select d from Developer d where d.login = :developerLogin", Developer.class)
                .setParameter("developerLogin", "alala").getSingleResult();

        session.save(new Project(manager, "Testing comment", "Test project for comment", timer));

        Project project = session.createQuery("select p from Project p where p.description = :description", Project.class)
                .setParameter("description", "Test project for comment").getSingleResult();

        session.save(new Task(project, "Task for comment", "Implement DAO tests", developer, timer));

        Task task = session.createQuery("select t from Task t where t.name = :name", Task.class)
                .setParameter("name", "Task for comment").getSingleResult();

        session.save(new Comment(developer, "my first comment", LocalDateTime.now(), task));

        foundComment = session.createQuery("select  c from Comment c where c.author.name = :authorName", Comment.class)
                .setParameter("authorName", "Dmitriy bragin").getSingleResult();

        assertThat(foundComment.getAuthor().getLogin(), is("alala"));
    }

    @Test
    public void saveFilterTest(){

        Filter foundFilter;

        Session session = SESSION_FACTORY.openSession();

        session.save(new Manager("Filter Filtrovich", "filterman", "filter@rambler.ru", "runner3",
                Department.FRONTEND));

        Manager manager = session.createQuery("select m from Manager m where m.login = :managerLogin", Manager.class)
                .setParameter("managerLogin", "tryharder").getSingleResult();

        session.save(new Filter(manager, "Test filter"));

        foundFilter = session.createQuery("select f from Filter f where f.name = :name", Filter.class)
                .setParameter("name", "Test filter").getSingleResult();
        assertThat(foundFilter.getName(), is("Test filter"));
    }
}