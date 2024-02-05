package personal.projects.jobportal.reviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.jobportal.reviews.models.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}
