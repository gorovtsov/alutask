package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BaseDaoTest {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate-test.cfg.xml").buildSessionFactory();

    @Test
    public void findAllUsersGenericTest(){
        Session session = SESSION_FACTORY.openSession();
        DeveloperDao developerDao = new DeveloperDao();

        session.close();

        List<Developer> developers = developerDao.findAll();

        assertThat(developers.isEmpty(), is(false));
    }

    @Test
    public void saveOrUpdateDeveloperTest(){
        Session session = SESSION_FACTORY.openSession();

        DeveloperDao dao = new DeveloperDao();

        Developer developer = new Developer("Baraban Pistoletov", "villy", "woop@gmail.com", "pass123",
                ProgrammingLanguage.PHP, DeveloperLevel.SENIOR);

        session.save(developer);
        session.close();

        Session newSession = SESSION_FACTORY.openSession();
        Developer foundDeveloper = dao.findById(developer.getId(), newSession);

        newSession.close();

        Session updateSession = SESSION_FACTORY.openSession();
        foundDeveloper.setLanguage(ProgrammingLanguage.PYTHON);
        long generatedId = dao.saveOrUpdate(foundDeveloper, updateSession);
        updateSession.close();

        assertEquals(generatedId, foundDeveloper.getId());
    }

    @Test
    public void deleteDeveloperTest() {
        DeveloperDao developerDao = new DeveloperDao();
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Developer developer = new Developer("John Matt", "mathew", "matter@gmail.com", "pass123",
                ProgrammingLanguage.RUBY, DeveloperLevel.SENIOR);
        session.save(developer);
        session.getTransaction().commit();

        System.out.println(developer.getEmail()+ " " + developer.getId());
        session.close();

        Session assertSession = SESSION_FACTORY.openSession();

        developerDao.delete(developer, assertSession);

        List<Developer> foundDeveloper = assertSession.createQuery("select d from Developer d where d.login = :devLogin", Developer.class)
                .setParameter("devLogin", "mathew")
                .getResultList();

        assertSession.close();
        System.out.println(foundDeveloper.toString());
        assertEquals(foundDeveloper.size(), 0);
    }

    @Test
    public void findDeveloperById(){
        Session session = SESSION_FACTORY.openSession();
        DeveloperDao developerDao = new DeveloperDao();

        Developer developer = new Developer("Peter Boss", "pete", "petya@gmail.com", "pass123",
                ProgrammingLanguage.HTML, DeveloperLevel.SENIOR);
        session.save(developer);
        long generatedId = developer.getId();
        session.close();

        System.out.println(generatedId);
        //Developer foundDeveloper = developerDao.findById(generatedId);
        Session newSession = SESSION_FACTORY.openSession();

        Developer foundDeveloper = developerDao.findById(generatedId, newSession);


        assertThat(foundDeveloper.getName(), is("Peter Boss"));
    }
}
