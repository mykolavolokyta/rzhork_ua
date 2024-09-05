package bebra.rzhork_ua.repository;

import bebra.rzhork_ua.model.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VacancyRepository {
    public List<Vacancy> getVacancies() {
        Vacancy vacancy1 = new Vacancy("Чистильщик унітазів", 5000, "Київ", "Bebra Inc", "Шукаємо криптознавців");
        Vacancy vacancy2 = new Vacancy("Криптоаналітик", 1000, "Узин", "UzynBit", "Шукаємо експертів");
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(vacancy1);
        vacancies.add(vacancy2);
        return vacancies;
    }
}
