package bebra.rzhork_ua.model.dto;

public class UserWithCompanyDTO {
    private String username;
    private String password;

    private String companyTitle;
    private String companyLocation;
    private String companyDescription;
    private int companyJoinYear;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCompanyJoinYear() {
        return companyJoinYear;
    }

    public void setCompanyJoinYear(int companyJoinYear) {
        this.companyJoinYear = companyJoinYear;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
