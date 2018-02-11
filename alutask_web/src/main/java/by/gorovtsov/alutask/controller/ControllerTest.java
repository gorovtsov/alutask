package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.Developer;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int elemsOnPage = 5;
        int pageNum = 1;
        List<Developer> developers = null;
        if(req.getParameter("elementsToShow") != null) {
            elemsOnPage = Integer.parseInt(req.getParameter("elementsToShow"));
            System.out.println(req.getParameter("elementsToShow"));
        }


        if(req.getParameter("pageToShow") != null){
            pageNum = Integer.parseInt(req.getParameter("pageToShow"));
            System.out.println(Integer.parseInt(req.getParameter("pageToShow")));
        }

        Map<Long, List<Developer>> developerMap = new ServiceTest().getDevelopersPortion(elemsOnPage, pageNum);

        long rowCount = 0L;
        for (Map.Entry<Long, List<Developer>> entry : developerMap.entrySet()) {
            rowCount = entry.getKey();
            developers = entry.getValue();
        }

        long pagesCount = rowCount % elemsOnPage;
        List<Long> pageNums = new ArrayList<Long>();

        for (long i = 1; i <= pagesCount; i++){
            pageNums.add(i);
        }

        req.setAttribute("pageNums", pageNums);
        req.setAttribute("developers", developers);
        req.getRequestDispatcher("/WEB-INF/jsp/developers.jsp").forward(req, resp);
    }
}
