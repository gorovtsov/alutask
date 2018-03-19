package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    private DeveloperRepository repository;

    @Override
    public List<Developer> findAll() {
        return (List<Developer>) repository.findAll();
    }

    @Override
    public List<Developer> findPageByLanguageAndLevel(ProgrammingLanguage language, DeveloperLevel level, int pageNum, int pageSize) {
        PageRequest pageRequest = new PageRequest(pageNum, pageSize);
        return repository.findByLanguageAndLevel(language, level, pageRequest).getContent();
    }

    @Override
    public List<Long> getPageNums(ProgrammingLanguage language, DeveloperLevel level, int pageSize) {
        Long count = repository.countByLanguageAndLevel(language, level);
        Long pages = count / pageSize + 1;
        List<Long> pageNums = new ArrayList<>();

        System.out.println(pages);
        for (Long i = 1L; i <= pages; i++) {
            pageNums.add(i);
        }

        return pageNums;
    }

    @Override
    public Developer findByLogin(String username) {
        return repository.findByLogin(username);
    }
}
