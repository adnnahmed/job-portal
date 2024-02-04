package personal.projects.jobportal.companies.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personal.projects.jobportal.companies.models.Company;
import personal.projects.jobportal.companies.repositories.CompanyRepository;
import personal.projects.jobportal.companies.services.CompanyService;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.jobs.models.Job;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public ResponseEntity<List<Company>> findAllCompanies() throws ResourceUnavailableException {
        List<Company> companiesList = companyRepository.findAll();
        if (companiesList.isEmpty()) {
            throw new ResourceUnavailableException("No data is available.");
        }
        return ResponseEntity.ok(companiesList);
    }

    @Override
    public ResponseEntity<Company> findSingleCompany(Long companyId) throws ResourceUnavailableException {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent())
            return ResponseEntity.ok(companyOptional.get());
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<Company> createJobRequest(Company company) {
        return new ResponseEntity<>(companyRepository.save(company), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Company> replaceJobRequest(Long companyId, Company company) throws ResourceUnavailableException {
        if (companyRepository.existsById(companyId)) {
            company.setId(companyId);
            return ResponseEntity.ok(companyRepository.save(company));
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<String> deleteJobRequest(Long companyId) throws ResourceUnavailableException {
        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
            return ResponseEntity.ok("Company with ID " + companyId + " has been deleted.");
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }
}
