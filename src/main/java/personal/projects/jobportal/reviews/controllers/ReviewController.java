package personal.projects.jobportal.reviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.projects.jobportal.companies.models.Company;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;
import personal.projects.jobportal.reviews.services.ReviewService;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() throws ResourceUnavailableException {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getSingleReview(@PathVariable Long reviewId) throws ResourceUnavailableException {
        return reviewService.getSingleReview(reviewId);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> replaceReview(@PathVariable Long reviewId, @RequestBody Review review) throws ResourceUnavailableException {
        return reviewService.replaceReview(reviewId, review);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) throws ResourceUnavailableException {
        return reviewService.deleteReview(reviewId);
    }
}
