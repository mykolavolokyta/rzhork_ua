package bebra.rzhork_ua.service;

import bebra.rzhork_ua.model.dto.VacancyFilterDTO;
import bebra.rzhork_ua.model.dto.VacancyWithRequirementDTO;
import bebra.rzhork_ua.model.entity.Company;
import bebra.rzhork_ua.model.entity.Requirement;
import bebra.rzhork_ua.model.entity.Vacancy;
import bebra.rzhork_ua.repository.RequirementRepository;
import bebra.rzhork_ua.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private RequirementRepository requirementRepository;

    public Page<Vacancy> getVacancies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return vacancyRepository.findAll(pageable);
    }

    public Page<Vacancy> getFilteredVacancies(VacancyFilterDTO filterDTO) {
        Pageable pageable = PageRequest.of(filterDTO.getPage(), 4);

        String search = (filterDTO.getSearch() == null ? "" : filterDTO.getSearch());
        Double minSalary = (filterDTO.getMinSalary() == null) ? 0.0 : filterDTO.getMinSalary();
        Double maxSalary = (filterDTO.getMaxSalary() == null) ? Double.MAX_VALUE : filterDTO.getMaxSalary();
        LocalDateTime startDate = (filterDTO.getStartDate() == null) ? LocalDateTime.of(1900, 1, 1, 0, 0) : filterDTO.getStartDate().atStartOfDay();
        LocalDateTime endDate = (filterDTO.getEndDate() == null) ? LocalDateTime.now() : filterDTO.getEndDate().atStartOfDay();

        return vacancyRepository.findFilteredVacancies(
                search,
                minSalary,
                maxSalary,
                startDate,
                endDate,
                pageable
        );
    }


    public Vacancy getVacancy(UUID id) {
        return vacancyRepository.findById(id).orElse(null);
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
