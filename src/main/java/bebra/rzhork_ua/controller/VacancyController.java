package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.Vacancy;
import bebra.rzhork_ua.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/vacancies")
    public String vacancies(Model model) {
        List<Vacancy> vacancies = vacancyService.getVacancies();
        model.addAttribute("vacancies", vacancies);
        return "vacancies";
    }
}
