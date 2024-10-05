package bebra.rzhork_ua.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor
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
}
