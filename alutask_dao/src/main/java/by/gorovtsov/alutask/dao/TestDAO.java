package by.gorovtsov.alutask.dao;

import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestDAO {
    public static void main(String[] args) {
        Map<Long, List<Developer>> developers = new DeveloperDao().getDevelopersPortion(10, 1);
        long count = 0L;
        for (Map.Entry<Long, List<Developer>> entry : developers.entrySet()) {
            count = entry.getKey();
        }
        System.out.println(count);
    }
}
