package bebra.rzhork_ua.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class UserWithCompanyDTO {
    private String username;
    private String password;

    private String companyTitle;
    private String companyLocation;
    private String companyDescription;
    private int companyJoinYear;
}
