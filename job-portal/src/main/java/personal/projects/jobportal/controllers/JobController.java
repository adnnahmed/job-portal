package personal.projects.jobportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.models.Job;
import personal.projects.jobportal.services.JobService;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public ResponseEntity<List<Job>> findAllJobsRequests() throws ResourceUnavailableException {
        return jobService.findAllJobsRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findSingleJobRequest(@PathVariable Long id) throws ResourceUnavailableException {
        return jobService.findSingleJobRequest(id);
    }

    @PostMapping
    public ResponseEntity<Job> createJobRequest(@RequestBody Job job) {
        return jobService.createJobRequest(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> replaceJobRequest(@RequestBody Job job) throws ResourceUnavailableException {
        return jobService.replaceJobRequest(job);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobRequest(@PathVariable Long id) throws ResourceUnavailableException {
        return jobService.deleteJobRequest(id);
    }
}
