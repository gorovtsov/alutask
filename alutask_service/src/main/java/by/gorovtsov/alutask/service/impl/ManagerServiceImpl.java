package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.user.Manager;
import by.gorovtsov.alutask.repository.ManagerRepository;
import by.gorovtsov.alutask.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Manager findManagetByUsername(String username) {
        return managerRepository.findByLogin(username);
    }
}
