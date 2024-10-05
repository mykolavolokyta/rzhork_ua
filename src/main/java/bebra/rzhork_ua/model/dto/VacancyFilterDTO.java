package bebra.rzhork_ua.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter @Setter
public class VacancyFilterDTO {
    private String search;
    private Double minSalary;
    private Double maxSalary;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private int page = 0;
}
