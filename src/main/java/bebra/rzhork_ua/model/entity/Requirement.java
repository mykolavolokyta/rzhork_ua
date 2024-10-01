package bebra.rzhork_ua.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String education;
    private String experience;
    private String skills;
    private String languageRequirements;
    private String workSchedule;
    private String additionalRequirements;

    @OneToOne(mappedBy = "requirement", cascade = CascadeType.ALL, optional = true)
    private Vacancy vacancy;

    public Requirement() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLanguageRequirements() {
        return languageRequirements;
    }

    public void setLanguageRequirements(String languageRequirements) {
        this.languageRequirements = languageRequirements;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public String getAdditionalRequirements() {
        return additionalRequirements;
    }

    public void setAdditionalRequirements(String additionalRequirements) {
        this.additionalRequirements = additionalRequirements;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
}
