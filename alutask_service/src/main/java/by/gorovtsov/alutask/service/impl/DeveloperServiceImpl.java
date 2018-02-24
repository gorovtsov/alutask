package by.gorovtsov.alutask.service.impl;

import by.gorovtsov.alutask.entity.dto.DeveloperPageDto;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.repository.DeveloperRepository;
import by.gorovtsov.alutask.service.DeveloperService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Getter
    @Setter
    @Autowired
    private DeveloperRepository developerRepository;

    @SuppressWarnings("unchecked")
    public DeveloperPageDto findFiltered(int offset, int limit, ProgrammingLanguage language, DeveloperLevel level) {
        List<Developer> developers =
                developerRepository
                        .findByLanguageAndLevel(language.toString().toUpperCase(),
                                                level.toString().toUpperCase(),
                                                (Pageable) new PageRequest(offset, limit));

        int totalCount = developerRepository.countByLanguageAndLevel(language, level);

        return new DeveloperPageDto(developers, totalCount);
    }

    @Override
    public List<Developer> findAll() {
        return (List<Developer>) developerRepository.findAll();
    }


}
