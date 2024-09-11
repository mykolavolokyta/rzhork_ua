package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.service.CompanyService;
import bebra.rzhork_ua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import bebra.rzhork_ua.utils.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @GetMapping("/companies")
    public String getCompanies(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "company/index";
    }

    @GetMapping("/companies/{id}")
    public String getCompanyDetails(@PathVariable UUID id, Model model) {
        Company company = companyService.getCompany(id);
        if (company == null) {
            return "redirect:/companies";
        }
        model.addAttribute("company", company);
        return "company/show";
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
}
