package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.dto.UserWithCompanyDTO;
import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @GetMapping("/jobseeker/register")
    public String registerJobSeeker() {
        return "auth/register/jobseeker";
    }

    @GetMapping("/company/register")
    public String registerCompany() {
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
