package personal.projects.jobportal.companies.services;

import org.springframework.http.ResponseEntity;
import personal.projects.jobportal.companies.models.Company;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;

import java.util.List;

public interface CompanyService {
    ResponseEntity<List<Company>> findAllCompanies() throws ResourceUnavailableException;
    ResponseEntity<Company> findSingleCompany(Long companyId) throws ResourceUnavailableException;
    ResponseEntity<Company> createJobRequest(Company company);
    ResponseEntity<Company> replaceJobRequest(Long companyId, Company company) throws ResourceUnavailableException;
    ResponseEntity<String> deleteJobRequest(Long jobId) throws ResourceUnavailableException;
}
