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
}
