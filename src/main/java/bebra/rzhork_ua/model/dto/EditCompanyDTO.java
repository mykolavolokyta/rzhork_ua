package bebra.rzhork_ua.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class EditCompanyDTO {
    private String title;
    private String location;
    private String description;
    private int joinYear;
}
