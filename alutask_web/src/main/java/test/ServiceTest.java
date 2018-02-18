package test;



import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.service.DeveloperService;

import java.util.List;

public class ServiceTest {

    public static void main(String[] args) {
        DeveloperService developerService = BeanHolderService.getDeveloperService();

        List<Developer> developers = developerService.findAll();
        developers.forEach(System.out::println);
    }
}
