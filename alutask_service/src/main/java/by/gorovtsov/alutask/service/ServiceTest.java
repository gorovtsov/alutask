package by.gorovtsov.alutask.service;

mport by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ServiceTest {

    @Autowired
    DeveloperRepository developerRepository;

    public Map<Long, List<Developer>> getDevelopersPortion(int elemsOnPage, int pageNum, ProgrammingLanguage langToFilter, DeveloperLevel devLevelToFilter) {
        return new DeveloperDao().getDevelopersPortion(elemsOnPage, pageNum, langToFilter, devLevelToFilter);
    }
    public static void main(String[] args) {
        List<Developer> developers = (List<Developer>) new ServiceTest().developerRepository.findAll();
        developers.forEach(System.out::println);
    }
}
