package personal.projects.jobportal.models;

import lombok.Data;

@Data
public class Job {

    private Long id;
    private String title;
    private String location;
    private String description;
    private String minSalary;
    private String maxSalary;
}
