package personal.projects.jobportal.jobs.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personal.projects.jobportal.jobs.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.jobs.models.Job;
import personal.projects.jobportal.jobs.repositories.JobRepository;
import personal.projects.jobportal.jobs.services.JobService;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public ResponseEntity<List<Job>> findAllJobsRequests() throws ResourceUnavailableException {
        List<Job> jobList = jobRepository.findAll();
        if (jobList.isEmpty()) {
            throw new ResourceUnavailableException("No data is available.");
        }
        return ResponseEntity.ok(jobList);
    }

    @Override
    public ResponseEntity<Job> findSingleJobRequest(Long jobId) throws ResourceUnavailableException {
        Optional<Job> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isPresent())
            return ResponseEntity.ok(jobOptional.get());
        throw new ResourceUnavailableException("Job request with ID " + jobId + " is unavailable.");
    }

    @Override
    public ResponseEntity<Job> createJobRequest(Job job) {
        return new ResponseEntity<>(jobRepository.save(job), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Job> replaceJobRequest(Long jobId, Job job) throws ResourceUnavailableException {
        if (jobRepository.existsById(jobId)) {
            job.setId(jobId);
            return ResponseEntity.ok(jobRepository.save(job));
        }
        throw new ResourceUnavailableException("Job request with ID " + jobId + " is unavailable.");
    }

    @Override
    public ResponseEntity<String> deleteJobRequest(Long jobId) throws ResourceUnavailableException {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
            return ResponseEntity.ok("Job request with ID " + jobId + " has been deleted.");
        }
        throw new ResourceUnavailableException("Job request with ID " + jobId + " is unavailable.");
    }
}
