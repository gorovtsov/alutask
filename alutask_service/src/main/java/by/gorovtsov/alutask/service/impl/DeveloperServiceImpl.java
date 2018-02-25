package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository repository;

    @Override
    public List<Developer> findAll() {
        return (List<Developer>) repository.findAll();
    }
}
