package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.dto.VacancyWithRequirementDTO;
import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.model.entity.Requirement;
import bebra.rzhork_ua.model.entity.Vacancy;
import bebra.rzhork_ua.repository.RequirementRepository;
import bebra.rzhork_ua.repository.VacancyRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private RequirementRepository requirementRepository;

    public List<Vacancy> getVacancies() {
        return vacancyRepository.findAll();
    }

    public Vacancy getVacancy(UUID id) {
        return vacancyRepository.findById(id).orElse(null);
    }

    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void saveVacancyRequirement(VacancyWithRequirementDTO dto, Company company) {
        Vacancy vacancy = new Vacancy();
        vacancy.setCompany(company);
        vacancy.setDescription(dto.getDescription());
        vacancy.setTitle(dto.getTitle());
        vacancy.setLocation(dto.getLocation());
        vacancy.setSalary(dto.getSalary());

        Requirement requirement = new Requirement();
        requirement.setEducation(dto.getEducation());
        requirement.setExperience(dto.getExperience());
        requirement.setSkills(dto.getSkills());
        requirement.setLanguageRequirements(dto.getLanguageRequirements());
        requirement.setWorkSchedule(dto.getWorkSchedule());
        requirement.setAdditionalRequirements(dto.getAdditionalRequirements());
        requirement.setVacancy(vacancy);
        requirementRepository.save(requirement);

        vacancy.setRequirement(requirement);
        vacancyRepository.save(vacancy);
    }

    public void updateVacancy(UUID id, VacancyWithRequirementDTO dto) {
        Vacancy vacancy = getVacancy(id);
        Requirement requirement = vacancy.getRequirement();

        vacancy.setTitle(dto.getTitle());
        vacancy.setLocation(dto.getLocation());
        vacancy.setSalary(dto.getSalary());
        vacancy.setDescription(dto.getDescription());

        requirement.setEducation(dto.getEducation());
        requirement.setExperience(dto.getExperience());
        requirement.setSkills(dto.getSkills());
        requirement.setLanguageRequirements(dto.getLanguageRequirements());
        requirement.setWorkSchedule(dto.getWorkSchedule());
        requirement.setAdditionalRequirements(dto.getAdditionalRequirements());
        
        requirementRepository.save(requirement);
        vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(UUID id) {
        vacancyRepository.deleteById(id);
    }

}
