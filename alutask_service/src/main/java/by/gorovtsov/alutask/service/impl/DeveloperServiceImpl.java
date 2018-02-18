package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.QDeveloper;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.service.DeveloperService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Autowired
    DeveloperRepository developerRepository;

    @SuppressWarnings("unchecked")
    public  List<Developer> findAll(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level) {
        QDeveloper developer = QDeveloper.developer;

        Predicate predicate = developer.language.eq(language).and(developer.level.eq(level));

        return developerRepository.findAll(predicate, new PageRequest(offset, limit)).getContent();
    }

    @Override
    public List<Developer> findAll() {
        return (List<Developer>) developerRepository.findAll();
    }


}
