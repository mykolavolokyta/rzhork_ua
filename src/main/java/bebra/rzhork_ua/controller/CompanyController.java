package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public String getCompanies(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "search", required = false) String search,
                               Model model) {
        Page<Company> companiesPage = companyService.getFilteredCompanies(search, page);
        model.addAttribute("companies", companiesPage.getContent());
        model.addAttribute("totalPages", companiesPage.getTotalPages());
        model.addAttribute("search", search);
        model.addAttribute("currentPage", page);
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
