package by.gorovtsov.alutask.dao;

import by.gorovtsov.alutask.dao.impl.DeveloperDao;
import by.gorovtsov.alutask.entity.user.Developer;

import java.util.List;
import java.util.Map;

public class TestDAO {
    public static void main(String[] args) {
        Map<Long, List<Developer>> developers = new DeveloperDao().getDevelopersPortion(10, 1, null, null);
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
