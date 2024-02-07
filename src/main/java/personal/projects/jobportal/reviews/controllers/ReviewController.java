package personal.projects.jobportal.reviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.projects.jobportal.companies.models.Company;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;
import personal.projects.jobportal.reviews.services.ReviewService;

import java.util.List;

/*
    Todo - Add User Entity
    Todo - **GET /reviews/user/{userId}:** Retrieve all reviews submitted by a specific user.
 */

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) throws ResourceUnavailableException {
        return reviewService.getAllReviews(companyId);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getSingleReview(@PathVariable Long companyId,
                                                  @PathVariable Long reviewId) throws ResourceUnavailableException {
        return reviewService.getSingleReview(companyId, reviewId);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@PathVariable Long companyId,
                                               @RequestBody Review review) throws ResourceUnavailableException {
        return reviewService.createReview(companyId, review);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> replaceReview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId,
                                                @RequestBody Review review) throws ResourceUnavailableException {
        return reviewService.replaceReview(companyId, reviewId, review);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId) throws ResourceUnavailableException {
        return reviewService.deleteReview(companyId, reviewId);
    }
}
