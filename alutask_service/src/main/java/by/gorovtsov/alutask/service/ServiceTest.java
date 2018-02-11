package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;

import java.util.List;
import java.util.Map;

public class ServiceTest {
    public List<Developer> getAllDevelopers() {
        DeveloperDao developerDao = new DeveloperDao();
        List<Developer> developerList = developerDao.findAll();

        return developerList;
    }

    public Map<Long, List<Developer>> getDevelopersPortion(int elemsOnPage, int pageNum){
        return new DeveloperDao().getDevelopersPortion(elemsOnPage, pageNum);
    }
}
