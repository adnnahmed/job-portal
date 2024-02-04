package personal.projects.jobportal.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import personal.projects.jobportal.models.Job;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository {

    List<Job> findAll();
    Optional<Job> findById(Long id);
    boolean existsById(Long jobId);
    Job save(Job job);
    void deleteById(Long id);
}