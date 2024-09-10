package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.dto.UserWithCompanyDTO;
import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/jobseeker/register")
    public String registerJobSeeker(Model model) {
        return "auth/register/jobseeker";
    }

    @GetMapping("/company/register")
    public String registerCompany(Model model) {
        return "auth/register/company";
    }

    @PostMapping("/jobseeker/register")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/vacancies";
    }

    @PostMapping("/company/register")
    public String addCompany(UserWithCompanyDTO userWithCompanyDTO) {
        userService.saveUserCompany(userWithCompanyDTO);
        return "redirect:/companies";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
