package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.dto.EditCompanyDTO;
import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.service.UserService;
import bebra.rzhork_ua.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/my/profile")
    public String myProfile(Model model) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
            return "jobseeker/profile";
        }
        return "redirect:/login";
    }

    @GetMapping("/company/profile")
    public String companyProfile(Model model) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            if (user != null && user.getCompany() != null) {
                Company company = user.getCompany();
                model.addAttribute("company", company);
                return "company/profile";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/my/profile/edit")
    public String editProfile(Model model) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
            return "jobseeker/edit";
        }
        return "redirect:/login";
    }

    @PostMapping("/my/profile/edit")
    public String updateProfile(@RequestParam String name) {
        String username = SecurityUtils.getCurrentUsername();
        User user = userService.findByUsername(username);
        if (user != null) {
            user.setName(name);
            userService.save(user);
        }
        return "redirect:/my/profile";
    }

    @GetMapping("/company/profile/edit")
    public String editCompanyProfile(Model model) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            if (user != null && user.getCompany() != null) {
                Company company = user.getCompany();
                model.addAttribute("company", company);
                return "company/edit";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/company/profile/edit")
    public String updateCompanyProfile(EditCompanyDTO dto){
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            if (user != null && user.getCompany() != null) {
                Company company = user.getCompany();
                company.setTitle(dto.getTitle());
                company.setDescription(dto.getDescription());
                company.setLocation(dto.getLocation());
                company.setJoinYear(dto.getJoinYear());
                user.setCompany(company);
                userService.save(user);
            }
        }
        return "redirect:/company/profile";
    }

}
