package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.entity.Vacancy;
import bebra.rzhork_ua.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancy> getVacancies() {
        return vacancyRepository.findAll();
    }

    public Vacancy getVacancy(UUID id) {
        return vacancyRepository.findById(id).orElse(null);
    }

    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void updateVacancy(UUID id, Vacancy vacancy) {
        Vacancy oldVacancy = getVacancy(id);
        vacancy.setId(id);
        vacancy.setCompany(oldVacancy.getCompany());
        vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(UUID id) {
        vacancyRepository.deleteById(id);
    }

}
