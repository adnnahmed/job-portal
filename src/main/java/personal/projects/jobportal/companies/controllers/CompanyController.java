package personal.projects.jobportal.companies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.projects.jobportal.companies.models.Company;
import personal.projects.jobportal.companies.services.CompanyService;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.jobs.models.Job;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies() throws ResourceUnavailableException {
        return companyService.findAllCompanies();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> findSingleCompany(@PathVariable Long companyId) throws ResourceUnavailableException {
        return companyService.findSingleCompany(companyId);
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return companyService.createJobRequest(company);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> replaceJobRequest(@PathVariable Long companyId,
                                                 @RequestBody Company company) throws ResourceUnavailableException {
        return companyService.replaceJobRequest(companyId, company);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteJobRequest(@PathVariable Long jobId) throws ResourceUnavailableException {
        return companyService.deleteJobRequest(jobId);
    }
}
