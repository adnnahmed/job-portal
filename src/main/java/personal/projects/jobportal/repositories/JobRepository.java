package personal.projects.jobportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import personal.projects.jobportal.models.Job;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @NonNull
    List<Job> findAll();
    @NonNull
    Optional<Job> findById(@NonNull Long id);
    @NonNull
    boolean existsById(@NonNull Long jobId);
    @NonNull
    Job save(@NonNull Job job);
    void deleteById(@NonNull Long id);
}