package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.entity.User;
import bebra.rzhork_ua.entity.Vacancy;
import bebra.rzhork_ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable UUID id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "profile";
    }
}
