package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.service.DeveloperService;
import by.gorovtsov.alutask.service.ServiceTest;
import by.gorovtsov.alutask.service.impl.BeanHolderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/paging")
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //DeveloperService developerService = BeanHolderService.getDeveloperService();
        //List<Developer> developerList = developerService.findAll();
        //req.setAttribute("developers", developerList);
        //req.getRequestDispatcher("/WEB-INF/jsp/developers.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
