package bebra.rzhork_ua.controller;

import bebra.rzhork_ua.model.Vacancy;
import bebra.rzhork_ua.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacancies")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public String getVacancies(Model model) {
        List<Vacancy> vacancies = vacancyService.getVacancies();
        model.addAttribute("vacancies", vacancies);
        return "vacancies";
    }

    @GetMapping("/{id}")
    public String getVacancy(@PathVariable String id, Model model) {
        Vacancy vacancy = vacancyService.getVacancyById(id);
        model.addAttribute("vacancy", vacancy);
        return "vacancy";
    }


    @PostMapping
    public String addVacancy(@RequestBody Vacancy vacancy) {
        vacancyService.addVacancy(vacancy);
        return "redirect:/vacancies";
    }

    @PutMapping("/{id}")
    public String updateVacancy(@PathVariable String id, @RequestBody Vacancy vacancy) {
        vacancyService.updateVacancy(id, vacancy);
        return "redirect:/vacancies/";
    }

    @DeleteMapping("/{id}")
    public String deleteVacancy(@PathVariable String id) {
        vacancyService.deleteVacancy(id);
        return "redirect:/vacancies";
    }
}
