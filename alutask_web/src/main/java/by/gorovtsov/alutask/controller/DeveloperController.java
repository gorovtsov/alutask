package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.dto.DeveloperDTO;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeveloperController {

    private final int PAGE_SIZE_DEFAULT = 5;
    private final int PAGE_NUM_DEFAULT = 1;

    private int pageNum = PAGE_NUM_DEFAULT;
    private int pageSize = PAGE_SIZE_DEFAULT;

    @Autowired
    private DeveloperService service;

    @ModelAttribute("programmingLanguages")
    public ProgrammingLanguage[] programmingLanguages() {
        return ProgrammingLanguage.values();
    }

    @ModelAttribute("developerFilter")
    public DeveloperDTO developerFilter() {
        return new DeveloperDTO();
    }

    @ModelAttribute("developerLevels")
    public DeveloperLevel[] developerLevels() {
        return DeveloperLevel.values();
    }

    @GetMapping(path = "/developers")
    public String developers(Model model) {
        List<Developer> developers = service.findPageByLanguageAndLevel(ProgrammingLanguage.JAVA, DeveloperLevel.JUNIOR,
                pageNum, pageSize);
        model.addAttribute("developers", developers);
        return "developers";
    }

    @PostMapping(path = "/developers")
    public String developersRefresh(Model model, DeveloperDTO developerDTO) {
        pageSize = developerDTO.getPageSize();
        ProgrammingLanguage language = developerDTO.getLanguage();
        DeveloperLevel level = developerDTO.getLevel();
        List<Developer> developers = service.findPageByLanguageAndLevel(language, level, 0, pageSize);
        List<Long> pageNums = service.getPageNums(language, level, pageSize);

        model.addAttribute("developers", developers);
        model.addAttribute("pageNums", pageNums);
        return "developers";
    }
}