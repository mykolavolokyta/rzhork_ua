package bebra.rzhork_ua.repository;

import bebra.rzhork_ua.model.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VacancyRepository {
    public List<Vacancy> getVacancies() {
        Vacancy vacancy = new Vacancy("Чистильщик унітазів", 5000, "Київ", "Bebra Inc", "Шукаємо криптознавців");
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(vacancy);
        return vacancies;
    }
}
