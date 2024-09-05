package bebra.rzhork_ua.model;

public class Vacancy {
    public String id;
    public String title;
    public double salary;
    public String location;
    public String company;
    public String description;

    public Vacancy(String id, String title, double salary, String location, String company, String description) {
        this.id = id;
        this.title = title;
        this.salary = salary;
        this.location = location;
        this.company = company;
        this.description = description;
    }
}
