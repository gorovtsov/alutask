package by.gorovtsov.alutask.service;

import by.gorovtsov.alutask.DAOTest;
import by.gorovtsov.alutask.entity.user.User;

public class ServiceTest {
    public User getUserTest() {
        return new DAOTest().getUserTest();
    }

    public static void main(String[] args) {
        System.out.println(new DAOTest().getUserTest());
    }
}
