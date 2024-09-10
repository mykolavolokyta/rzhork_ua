package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.entity.User;
import bebra.rzhork_ua.model.entity.Vacancy;
import bebra.rzhork_ua.service.UserService;
import bebra.rzhork_ua.service.VacancyService;
import bebra.rzhork_ua.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/vacancies")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getVacancies(Model model) {
        List<Vacancy> vacancies = vacancyService.getVacancies();
        model.addAttribute("vacancies", vacancies);
        return "vacancy/index";
    }

    @GetMapping("/{id}")
    public String getVacancy(@PathVariable UUID id, Model model) {
        Vacancy vacancy = vacancyService.getVacancy(id);
        model.addAttribute("vacancy", vacancy);
        return "vacancy/show";
    }

    @GetMapping("/create")
    public String createVacancy() {
        return "vacancy/create";
    }

    @GetMapping("/edit/{id}")
    public String editVacancy(@PathVariable UUID id, Model model) {
        Vacancy vacancy = vacancyService.getVacancy(id);
        model.addAttribute("vacancy", vacancy);
        return "vacancy/edit";
    }

    @PostMapping("/create")
    public String addVacancy(Vacancy vacancy) {
        String username = SecurityUtils.getCurrentUsername();
        if (username != null) {
            User user = userService.findByUsername(username);
            vacancy.setCompany(user.getCompany());
            vacancyService.addVacancy(vacancy);
            return "redirect:/vacancies";
        }
        return "redirect:/login";
    }

    @PostMapping("/edit/{id}")
    public String updateVacancy(@PathVariable UUID id, Vacancy vacancy) {
        vacancyService.updateVacancy(id, vacancy);
        return "redirect:/vacancies";
    }

    @PostMapping("/delete/{id}")
    public String deleteVacancy(@PathVariable UUID id) {
        vacancyService.deleteVacancy(id);
        return "redirect:/vacancies";
    }
}
