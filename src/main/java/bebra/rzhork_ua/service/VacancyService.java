package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.Vacancy;
import bebra.rzhork_ua.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancy> getVacancies() {
        return vacancyRepository.getVacancies();
    }

    public Vacancy getVacancyById(String id) {
        return vacancyRepository.getVacancyById(id);
    }

    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.addVacancy(vacancy);
    }

    public void updateVacancy(String id, Vacancy vacancy) {
        vacancyRepository.updateVacancy(id, vacancy);
    }

    public void deleteVacancy(String id) {
        vacancyRepository.deleteVacancy(id);
    }

}
