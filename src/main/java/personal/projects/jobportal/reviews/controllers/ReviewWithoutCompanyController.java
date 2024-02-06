package personal.projects.jobportal.reviews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;
import personal.projects.jobportal.reviews.services.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewWithoutCompanyController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewWithoutCompanyController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/all-reviews")
    public ResponseEntity<List<Review>> getAllReviewsOfAllCompanies() throws ResourceUnavailableException {
        return reviewService.getAllReviewsOfAllCompanies();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getSingleReviewWithoutCompany(@PathVariable Long reviewId) throws ResourceUnavailableException {
        return reviewService.getSingleReviewWithoutCompany(reviewId);
    }
}
