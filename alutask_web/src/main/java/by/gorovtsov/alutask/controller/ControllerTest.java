package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.BeanHolderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/developers")
public class ControllerTest extends HttpServlet {

    DeveloperService developerService = BeanHolderService.getDeveloperService();

    public static final int DEFAULT_PAGE_SIZE_VALUE = 5;
    private int pageSize = DEFAULT_PAGE_SIZE_VALUE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int pageNum = 1;
        List<Developer> developers = null;

        ProgrammingLanguage language = null;
        DeveloperLevel level = null;

        req.setAttribute("programmingLanguages", ProgrammingLanguage.values());
        req.setAttribute("developerLevels", DeveloperLevel.values());
        System.out.println("DEBUNG 1 " + language + " " + level);

        if (req.getSession().getAttribute("currentProgLanguageFilter") != null) {
            language = ProgrammingLanguage.valueOf(req.getSession().getAttribute("currentProgLanguageFilter").toString());
            if (req.getSession().getAttribute("currentDevLevelFilter") != null) {
                level = DeveloperLevel.valueOf(req.getSession().getAttribute("currentDevLevelFilter").toString());
                System.out.println("DEBUNG 2 " + language + " " + level);
            }
        }

        if (req.getParameter("programmingLanguageFilter") != null) {
            language = ProgrammingLanguage.valueOf(req.getParameter("programmingLanguageFilter").toString().toUpperCase());
            if (req.getParameter("developerLevelFilter") != null) {
                level = DeveloperLevel.valueOf(req.getParameter("developerLevelFilter").toString().toUpperCase());
            }
        }

        req.getSession().setAttribute("currentProgLanguageFilter", language);
        req.getSession().setAttribute("currentDevLevelFilter", level);


        if (req.getSession().getAttribute("currentElementsToShow") != null) {
            pageSize = Integer.parseInt(req.getSession().getAttribute("currentElementsToShow").toString());
        }

        if (req.getParameter("elementsToShow") != null) {
            pageSize = Integer.parseInt(req.getParameter("elementsToShow"));
            req.getSession().setAttribute("currentElementsToShow", pageSize);
        }

        if (req.getParameter("pageToShow") != null) {
            pageNum = Integer.parseInt(req.getParameter("pageToShow"));
            System.out.println(Integer.parseInt(req.getParameter("pageToShow")));
        }

        developers = developerService.findAll(--pageNum, pageSize, language, level);

        long rowCount = developers.size();

        long pagesCount = rowCount / pageSize + 1;
        List<Long> pageNums = new ArrayList<>();
        for (long i = 1; i <= pagesCount; i++) {
            pageNums.add(i);
        }

        req.setAttribute("pageNums", pageNums);
        req.setAttribute("developers", developers);
        req.getRequestDispatcher("/WEB-INF/jsp/developers.jsp").forward(req, resp);
    }
}
