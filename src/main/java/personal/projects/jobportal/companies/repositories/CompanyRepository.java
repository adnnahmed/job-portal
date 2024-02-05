package personal.projects.jobportal.companies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.jobportal.companies.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
