package bebra.rzhork_ua.model.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class VacancyWithRequirementDTO {
    private String title;
    private String location;
    private double salary;
    private String description;

    private String education;
    private String experience;
    private String skills;
    private String languageRequirements;
    private String workSchedule;
    private String additionalRequirements;
}
