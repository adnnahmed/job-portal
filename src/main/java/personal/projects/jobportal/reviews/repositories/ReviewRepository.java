package personal.projects.jobportal.reviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import personal.projects.jobportal.reviews.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
