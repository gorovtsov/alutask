package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.service.ServiceTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/developers")
public class ControllerTest extends HttpServlet {

    public static final int DEFAULT_PAGE_SIZE_VALUE = 5;
    private int elemsOnPage = DEFAULT_PAGE_SIZE_VALUE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = 1;
        List<Developer> developers = null;

        ProgrammingLanguage langToFilter = null;
        DeveloperLevel devLevelToFilter = null;

        req.setAttribute("programmingLanguages", ProgrammingLanguage.values());
        req.setAttribute("developerLevels", DeveloperLevel.values());
        System.out.println("DEBUNG 1 " + langToFilter + " " + devLevelToFilter);

        if (req.getSession().getAttribute("currentProgLanguageFilter") != null) {
            langToFilter = ProgrammingLanguage.valueOf(req.getSession().getAttribute("currentProgLanguageFilter").toString());
            if (req.getSession().getAttribute("currentDevLevelFilter") != null) {
                devLevelToFilter = DeveloperLevel.valueOf(req.getSession().getAttribute("currentDevLevelFilter").toString());
                System.out.println("DEBUNG 2 " + langToFilter + " " + devLevelToFilter);
            }
        }

        if (req.getParameter("programmingLanguageFilter") != null) {
            langToFilter = ProgrammingLanguage.valueOf(req.getParameter("programmingLanguageFilter").toString());
            if (req.getParameter("developerLevelFilter") != null) {
                devLevelToFilter = DeveloperLevel.valueOf(req.getParameter("developerLevelFilter").toString());
            }
        }

        req.getSession().setAttribute("currentProgLanguageFilter", langToFilter);
        req.getSession().setAttribute("currentDevLevelFilter", devLevelToFilter);


        if (req.getSession().getAttribute("currentElementsToShow") != null) {
            elemsOnPage = Integer.parseInt(req.getSession().getAttribute("currentElementsToShow").toString());
        }

        if (req.getParameter("elementsToShow") != null) {
            elemsOnPage = Integer.parseInt(req.getParameter("elementsToShow"));
            req.getSession().setAttribute("currentElementsToShow", elemsOnPage);
        }

        if (req.getParameter("pageToShow") != null) {
            pageNum = Integer.parseInt(req.getParameter("pageToShow"));
            System.out.println(Integer.parseInt(req.getParameter("pageToShow")));
        }

        Map<Long, List<Developer>> developerMap = new ServiceTest().getDevelopersPortion(elemsOnPage, pageNum, langToFilter, devLevelToFilter);

        long rowCount = 0L;
        for (Map.Entry<Long, List<Developer>> entry : developerMap.entrySet()) {
            rowCount = entry.getKey();
            developers = entry.getValue();
        }

        long pagesCount = rowCount / elemsOnPage + 1;
        List<Long> pageNums = new ArrayList<>();
        for (long i = 1; i <= pagesCount; i++) {
            pageNums.add(i);
        }

        req.setAttribute("pageNums", pageNums);
        req.setAttribute("developers", developers);
        req.getRequestDispatcher("/WEB-INF/jsp/developers.jsp").forward(req, resp);
    }
}
