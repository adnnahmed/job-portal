package personal.projects.jobportal.reviews.services;

import org.springframework.http.ResponseEntity;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;

import java.util.List;

public interface ReviewService {

    ResponseEntity<List<Review>> getAllReviews(Long companyId) throws ResourceUnavailableException;
    ResponseEntity<Review> getSingleReview(Long companyId, Long reviewId) throws ResourceUnavailableException;
    ResponseEntity<Review> createReview(Long companyId, Review review) throws ResourceUnavailableException;
    ResponseEntity<Review> replaceReview(Long companyId, Long reviewId, Review review) throws ResourceUnavailableException;
    ResponseEntity<String> deleteReview(Long companyId, Long reviewId) throws ResourceUnavailableException;
    ResponseEntity<List<Review>> getAllReviewsOfAllCompanies() throws ResourceUnavailableException;
    ResponseEntity<Review> getSingleReviewWithoutCompany(Long reviewId) throws ResourceUnavailableException;
}
