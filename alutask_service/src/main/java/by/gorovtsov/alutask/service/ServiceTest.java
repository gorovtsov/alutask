package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;

import java.util.List;
import java.util.Map;

public class ServiceTest {
    public List<Developer> getAllDevelopers() {
        DeveloperDao developerDao = new DeveloperDao();
        List<Developer> developerList = developerDao.findAll();

        return developerList;
    }

    public Map<Long, List<Developer>> getDevelopersPortion(int elemsOnPage, int pageNum, ProgrammingLanguage langToFilter, DeveloperLevel devLevelToFilter) {
        return new DeveloperDao().getDevelopersPortion(elemsOnPage, pageNum, langToFilter, devLevelToFilter);
    }
    public static void main(String[] args) {
        Map<Long, List<Developer>> developers = new ServiceTest().getDevelopersPortion(10, 1, ProgrammingLanguage.JAVA, DeveloperLevel.ALEXANDERGOROVTSOV);
        long count = 0L;
        List<Developer> developerList = null;
        for (Map.Entry<Long, List<Developer>> entry : developers.entrySet()) {
            count = entry.getKey();
            developerList = entry.getValue();
        }
        for (Developer developer : developerList) {
            System.out.println(developer);
        }
    }
}
