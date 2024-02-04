package personal.projects.jobportal.jobs.models;

import jakarta.persistence.*;
import lombok.*;
import personal.projects.jobportal.companies.models.Company;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String location;
    private String description;
    private String minSalary;
    private String maxSalary;
    @ManyToOne
    private Company company;
}
