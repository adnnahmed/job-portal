package personal.projects.jobportal.reviews.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personal.projects.jobportal.companies.services.CompanyService;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;
import personal.projects.jobportal.reviews.models.Review;
import personal.projects.jobportal.reviews.repositories.ReviewRepository;
import personal.projects.jobportal.reviews.services.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Autowired
    public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public ResponseEntity<List<Review>> getAllReviews(Long companyId) throws ResourceUnavailableException {
        if (companyService.existsByCompanyId(companyId)) {
            List<Review> reviewsList = reviewRepository.findByCompanyId(companyId);
            if (reviewsList.isEmpty()) {
                throw new ResourceUnavailableException("No data is available.");
            }
            return ResponseEntity.ok(reviewsList);
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<Review> getSingleReview(Long companyId, Long reviewId) throws ResourceUnavailableException {
        if (companyService.existsByCompanyId(companyId)) {
            Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
            if (reviewOptional.isPresent()) {
                if (reviewOptional.get().getCompany().getId().equals(companyId)) {
                    return ResponseEntity.ok(reviewOptional.get());
                }
            }
            throw new ResourceUnavailableException("Review with ID " + reviewId + " is unavailable.");
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<Review> createReview(Long companyId, Review review) throws ResourceUnavailableException {
        if (companyService.existsByCompanyId(companyId)) {
            review.setCompany(companyService.findSingleCompany(companyId).getBody());
            return new ResponseEntity<>(reviewRepository.save(review), HttpStatus.CREATED);
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<Review> replaceReview(Long companyId, Long reviewId, Review review) throws ResourceUnavailableException {
        if (companyService.existsByCompanyId(companyId)) {
            if (reviewRepository.existsById(reviewId)) {
                review.setId(reviewId);
                review.setCompany(companyService.findSingleCompany(companyId).getBody());
                return ResponseEntity.ok(reviewRepository.save(review));
            }
            throw new ResourceUnavailableException("Review with ID " + reviewId + " is unavailable.");
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<String> deleteReview(Long companyId, Long reviewId) throws ResourceUnavailableException {
        if (companyService.existsByCompanyId(companyId)) {
            Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
            if (reviewOptional.isPresent()) {
                if (reviewOptional.get().getCompany().getId().equals(companyId)) {
                    reviewRepository.deleteById(reviewId);
                    return ResponseEntity.ok("Review with ID " + reviewId + " has been deleted.");
                }
            }
            throw new ResourceUnavailableException("Review with ID " + reviewId + " is unavailable.");
        }
        throw new ResourceUnavailableException("Company with ID " + companyId + " is unavailable.");
    }

    @Override
    public ResponseEntity<List<Review>> getAllReviewsOfAllCompanies() throws ResourceUnavailableException {
        List<Review> reviewsList = reviewRepository.findAll();
        if (reviewsList.isEmpty()) {
            throw new ResourceUnavailableException("No data is available.");
        }
        return ResponseEntity.ok(reviewsList);
    }

    @Override
    public ResponseEntity<Review> getSingleReviewWithoutCompany(Long reviewId) throws ResourceUnavailableException {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            return ResponseEntity.ok(reviewOptional.get());
        }
        throw new ResourceUnavailableException("Review with ID " + reviewId + " is unavailable.");
    }
}
