package personal.projects.jobportal.reviews.services;

import org.springframework.http.ResponseEntity;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;

import java.util.List;

public interface ReviewService {

    ResponseEntity<List<Review>> getAllReviews() throws ResourceUnavailableException;
    ResponseEntity<Review> getSingleReview(Long reviewId) throws ResourceUnavailableException;
    ResponseEntity<Review> createReview(Review review);
    ResponseEntity<Review> replaceReview(Long reviewId, Review review) throws ResourceUnavailableException;
    ResponseEntity<String> deleteReview(Long reviewId) throws ResourceUnavailableException;
}
