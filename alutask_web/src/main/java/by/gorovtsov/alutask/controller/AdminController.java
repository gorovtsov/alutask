package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.dto.DeveloperDTO;
import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.service.AdminService;
import by.gorovtsov.alutask.service.DeveloperService;
import by.gorovtsov.alutask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
public class AdminController {

    private UserService userservice;
    private AdminService adminService;

    @Autowired
    public AdminController(UserService userService, AdminService adminService) {
        this.userservice = userService;
        this.adminService = adminService;
    }

    @ModelAttribute("programmingLanguages")
    public Role[] programmingLanguages() {
        return Role.values();
    }

    @ModelAttribute("developerLevels")
    public DeveloperLevel[] developerLevels() {
        return DeveloperLevel.values();
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        List<User> guests = userservice.findAllGuests();
        model.addAttribute("guests", guests);
        return "admin";
    }

    @GetMapping("/admin/addDeveloper/{userId}")
    public String addDeveloper(@PathVariable("userId") Long userId, Model model) {
        User user = userservice.findUserById(userId);
        model.addAttribute("devDTO", new DeveloperDTO());
        model.addAttribute("user", user);
        return "developerForm";
    }

    @GetMapping("/admin/addManager/{userId}")
    public String addManager(@PathVariable("userId") Long userId, Model model) {
        User user = userservice.findUserById(userId);
        model.addAttribute("user", user);
        return "managerForm";
    }

    @PostMapping("/admin/addDeveloper/{userId}")
    public String setDeveloperAuthority(@PathVariable("userId") Long userId, DeveloperDTO developerDTO, User user, Model model) {
        adminService.addDeveloper(user, developerDTO);
        return  null;
    }

    @PostMapping("/admin/addManager/{userId}")
    public String setManagerAuthority(@PathVariable("userId") Long userId, Model model) {
        return null;
    }
}
