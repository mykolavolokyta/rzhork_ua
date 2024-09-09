package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.entity.Company;
import bebra.rzhork_ua.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String getCompanies(Model model) {
        List<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "company/index";
    }

    @GetMapping("/{id}")
    public String getCompanyDetails(@PathVariable UUID id, Model model) {
        Company company = companyService.getCompany(id);
        if (company == null) {
            return "redirect:/companies";
        }
        model.addAttribute("company", company);
        return "company/show";
    }
}
