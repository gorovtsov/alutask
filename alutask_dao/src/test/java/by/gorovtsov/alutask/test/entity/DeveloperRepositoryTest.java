package by.gorovtsov.alutask.test.entity;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.QDeveloper;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DeveloperRepositoryTest extends BaseRepositoryTest {
    @Autowired
    DeveloperRepository developerRepository;

    @Test
    public void findAlltest(){
        List<Developer> developers = (List<Developer>) developerRepository.findAll();

        developers.forEach(System.out::println);
        System.out.println(developers.size());
    }

    @Test
    public void findAllPagedQuerydsl(){
        QDeveloper developer = QDeveloper.developer;

        ProgrammingLanguage language = null;
        DeveloperLevel level = DeveloperLevel.ALEXANDERGOROVTSOV;
        Predicate predicate = developer.language.eq(ProgrammingLanguage.JAVA).and(developer.level.eq(DeveloperLevel.ALEXANDERGOROVTSOV));


        Page<Developer> developers = developerRepository.findAll(predicate, new PageRequest(0, 5));
        List<Developer> developerList = developers.getContent();
        developerList.forEach(System.out::println);
    }
}
