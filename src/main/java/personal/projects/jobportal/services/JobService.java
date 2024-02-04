package personal.projects.jobportal.services;

import org.springframework.http.ResponseEntity;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.models.Job;

import java.util.List;

public interface JobService {
    ResponseEntity<List<Job>> findAllJobsRequests() throws ResourceUnavailableException;
    ResponseEntity<Job> findSingleJobRequest(Long jobId) throws ResourceUnavailableException;
    ResponseEntity<Job> createJobRequest(Job job);
    ResponseEntity<Job> replaceJobRequest(Long jobId, Job job) throws ResourceUnavailableException;
    ResponseEntity<String> deleteJobRequest(Long jobId) throws ResourceUnavailableException;
}
