package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.user.User;
import by.gorovtsov.alutask.enumeration.Role;
import by.gorovtsov.alutask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        if (validateUser(user)){
            userService.registerNewUser(user);
            return "login";
        } else {
            return "registration";
        }
    }

    private boolean validateUser(User user) {
        if (user != null) {
            if (user.getLogin() != null && user.getPassword() != null
                    && user.getEmail() != null && user.getName() != null){
                user.setRole(Role.GUEST);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
