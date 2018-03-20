package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class DeveloperRepositoryTest extends BaseTest {

    @Autowired
    DeveloperRepository developerRepository;

    @Test
    public void findDeveloperByLogin() {
        Developer developer = developerRepository.findByLogin("garavek");
        assertThat(Role.DEVELOPER.toString(), is(developer.getRole().toString()));
    }

    @Test
    public void findAllDeveloperTest() {
        List<Developer> developers = developerRepository.findAll();
        assertTrue(developers.size() > 10);
    }

    @Test
    public void findPage() {

        Page<Developer> developers = developerRepository.findByLanguageAndLevel(ProgrammingLanguage.JAVA, DeveloperLevel.JUNIOR, new PageRequest(0, 5));

        assertNotNull(developers);
    }

    @Test
    public void countByLanguageAndLevelTest() {
        Long count = developerRepository.countByLanguageAndLevel(ProgrammingLanguage.JAVA, DeveloperLevel.ALEXANDERGOROVTSOV);

        assertTrue(count != 0);
    }
}
