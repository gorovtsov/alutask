package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

public class DeveloperServiceImpl {

    @Resource
    DeveloperRepository developerRepository;

    public  List<Developer> findAll(int offset, int limit) {
        return developerRepository.findAll(new PageRequest(offset, limit));
    }
}
