package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.DAOTest;
import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.User;

import java.util.List;

public class ServiceTest {
    public User getUserTest() {
        return new DAOTest().getUserTest();
    }
    public List<Developer> getAllDevelopers(){
        DeveloperDao developerDao = new DeveloperDao();
        List<Developer> developerList = developerDao.findAll();

        return developerList;
    }
}
