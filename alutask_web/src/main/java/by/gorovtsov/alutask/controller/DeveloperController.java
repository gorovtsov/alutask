package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @GetMapping(path = "/developers")
    public String developers(Model model) {
        List<Developer> developers = service.findAll();
        model.addAttribute("developers", developers);
        return "developers";
    }
}