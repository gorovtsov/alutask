package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.service.DeveloperService;
import by.gorovtsov.alutask.service.ManagerService;
import by.gorovtsov.alutask.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class ProfileController {

    private User currentUser;
    private final ProjectService projectService;
    private final DeveloperService developerService;
    private final ManagerService managerService;

    @Autowired
    public ProfileController(DeveloperService developerService, ManagerService managerService, ProjectService projectService){
        this.developerService = developerService;
        this.managerService = managerService;
        this.projectService = projectService;
    }

    @ModelAttribute("projects")
    public List<Project> projects() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Project> projects = projectService.findEnding5ByManagerLogin(login);
        return projects;
    }

    @GetMapping("/profile")
    public String goToProfile(Model model, Authentication authentication) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("MANAGER"))) {
            currentUser = managerService.findManagetByUsername(currentUsername);
        }

        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("DEVELOPER"))) {
            currentUser = developerService.findByLogin(currentUsername);
        }

        model.addAttribute("user", currentUser);
        return "profile";
    }
}
