package au.com.daisbuild.daisbuild.controller;

import au.com.daisbuild.daisbuild.payload.ReviewDto;
import au.com.daisbuild.daisbuild.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("{id}")
    public ReviewDto getReviewById(@PathVariable long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public ReviewDto addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @DeleteMapping("{id}")
    public String addReview(@PathVariable long id) {
        return reviewService.deleteReviewById(id);
    }
}
