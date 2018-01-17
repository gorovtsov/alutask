package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.testdao.DAOTest;

public class ServiceTest {
    public String getStringValue(){
        return new DAOTest().getStringValue();
    }
}
