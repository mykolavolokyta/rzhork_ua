package bebra.rzhork_ua.repository;

import bebra.rzhork_ua.model.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VacancyRepository {
    public List<Vacancy> getVacancies() {
        Vacancy vacancy1 = new Vacancy("1", "Чистильщик унітазів", 5000, "Київ", "Bebra Inc", "Шукаємо криптознавців");
        Vacancy vacancy2 = new Vacancy("2", "Криптоаналітик", 1000, "Узин", "UzynBit", "Шукаємо експертів");
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(vacancy1);
        vacancies.add(vacancy2);
        return vacancies;
    }

    public Vacancy getVacancyById(String id) {
        return new Vacancy("1", "Чистильщик унітазів", 5000, "Київ", "Bebra Inc", "Шукаємо криптознавців");
    }

    public void addVacancy(Vacancy vacancy) {
        System.out.println("Added vacancy");
    }

    public void updateVacancy(String id, Vacancy vacancy) {
        System.out.println("Update vacancy");
    }

    public void deleteVacancy(String id) {
        System.out.println("Deleted vacancy");
    }
}
