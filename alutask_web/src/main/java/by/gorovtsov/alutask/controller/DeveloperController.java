package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.dto.DeveloperPageDto;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"currentDevLevelFilter", "currentProgLanguageFilter", "currentPageNum", "currentPageSize"})
public class DeveloperController {

    @Autowired
    DeveloperService developerService;

    private int currentPageNum;
    private int currentPageSize;
    private ProgrammingLanguage programmingLanguage;
    private DeveloperLevel developerLevel;
    List<Developer> developers;

    //default values init
    {
        currentPageNum = 1;
        currentPageSize = 5;
        programmingLanguage = ProgrammingLanguage.JAVA;
        developerLevel = DeveloperLevel.JUNIOR;
    }

    @GetMapping(path = "/developers")
    public String showDevelopers(Model model, int pageNum, int pageSize, String languageToFilter, String levelToFilter ) {
        DeveloperPageDto page = null;
        List<Integer> pageNumsList = null;

        int totalCount = 0;
        //setting filtering variables

        model.addAttribute("programmingLanguages", ProgrammingLanguage.values());
        model.addAttribute("developeLevels", DeveloperLevel.values());

        //setting page and filter parameters
        setCurrentPageNum(pageNum);
        setCurrentPageSize(pageSize);
        setProgrammingLanguage(languageToFilter, model);
        setDeveloperLevel(levelToFilter, model);

        if (!model.containsAttribute("currentProgLanguageFilter")) {
            model.addAttribute("currentProgLanguageFilter", programmingLanguage);
        }

        if (!model.containsAttribute("currentDevLevelFilter")) {
            model.addAttribute("currentDevLevelFilter", developerLevel);
        }

        page = developerService
                .findFiltered(currentPageNum, currentPageSize, programmingLanguage, developerLevel);

        developers = page.getDevelopers();
        pageNumsList = getPageNumsList(page.getTotalCount(), pageSize);

        model.addAttribute("pageNums", pageNumsList);
        model.addAttribute("developers", developers);

        return "developers";
    }


    private void setProgrammingLanguage(String language, Model model) {
        if (language != null){
            programmingLanguage = ProgrammingLanguage.valueOf(language.toUpperCase());
            model.addAttribute("currentProgLanguageFilter", programmingLanguage);
        }
    }

    private void setDeveloperLevel(String level, Model model) {
        if (level != null) {
            developerLevel = DeveloperLevel.valueOf(level.toUpperCase());
            model.addAttribute("currentDevLevelFilter", developerLevel);
        }
    }

    private void setCurrentPageNum(int pageNum) {
        this.currentPageNum = pageNum;
    }

    private void setCurrentPageSize(int pageSize) {
        this.currentPageSize = pageSize;
    }

    private List<Integer> getPageNumsList(int totalCount, int pageSize) {
        List<Integer> pageNumsList = new ArrayList<>();

        int pagesCount = totalCount % pageSize;
        for (int i = 1; i <= pagesCount; i++) {
            pageNumsList.add(i);
        }

        return pageNumsList;
    }
}