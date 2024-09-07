package bebra.rzhork_ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
