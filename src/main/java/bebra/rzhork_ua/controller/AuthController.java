package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.entity.User;
import bebra.rzhork_ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @PostMapping("/register")
    public String addUser(User user) {
        userService.saveUser(user, "ROLE_VIEWER");
        return "redirect:/vacancies";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
