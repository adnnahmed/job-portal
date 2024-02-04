package personal.projects.jobportal.reviews.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personal.projects.jobportal.companies.models.Company;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;
import personal.projects.jobportal.reviews.repositories.ReviewRepository;
import personal.projects.jobportal.reviews.services.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ResponseEntity<List<Review>> getAllReviews() throws ResourceUnavailableException {
        List<Review> reviewsList = reviewRepository.findAll();
        if (reviewsList.isEmpty()) {
            throw new ResourceUnavailableException("No data is available.");
        }
        return ResponseEntity.ok(reviewsList);
    }

    @Override
    public ResponseEntity<Review> getSingleReview(Long reviewId) throws ResourceUnavailableException {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent())
            return ResponseEntity.ok(reviewOptional.get());
        throw new ResourceUnavailableException("Company with ID " + reviewId + " is unavailable.");
    }

    @Override
    public ResponseEntity<Review> createReview(Review review) {
        return new ResponseEntity<>(reviewRepository.save(review), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Review> replaceReview(Long reviewId, Review review) throws ResourceUnavailableException {
        if (reviewRepository.existsById(reviewId)) {
            review.setId(reviewId);
            return ResponseEntity.ok(reviewRepository.save(review));
        }
        throw new ResourceUnavailableException("Company with ID " + reviewId + " is unavailable.");
    }

    @Override
    public ResponseEntity<String> deleteReview(Long reviewId) throws ResourceUnavailableException {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return ResponseEntity.ok("Company with ID " + reviewId + " has been deleted.");
        }
        throw new ResourceUnavailableException("Company with ID " + reviewId + " is unavailable.");
    }
}
